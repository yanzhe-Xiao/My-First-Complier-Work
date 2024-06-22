package genCode;

import genCode.msgStructure.MemberMsg;
import genCode.msgStructure.ScopedMemMsg;
import genCode.msgStructure.StructMsg;
import Semantics.Check;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import Symbol.SymbolNode;
import Symbol.SymbolTable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 整合词法语法语义+生成hxx代码文件
 */
public class genHxx {
    private static final String OUTPUT_FILE_NAME = "./output/struct_nest.hxx";
    private static SymbolTable symbolTable;
    private static ArrayList<StructMsg> structs;
    private static Map<String, String> equalType;

    public static void main(String[] args) throws IOException {
        String name = Check.inputFileName;
        name = name.replace("\"", "").replace("txt", "").replace(".", "");
        name = name.split("/")[2];
        catchAllMsg();
        generateHxxFile(name);
    }

    /**
     * 调用前端检查,从生成的符号表中提取所有内容
     * @throws IOException
     */
    public static void catchAllMsg() throws IOException {
        Check.check();
        symbolTable = Check.semanticChecker.symbolTable;
        initializeEqualTypeMap();
        structs = new ArrayList<>();
        collectAllStructs();
    }

    private static void initializeEqualTypeMap() {
        equalType = new HashMap<>();
        equalType.put("int16", "short");
        equalType.put("int32", "long");
        equalType.put("int64", "long long");
        equalType.put("uint16", "unsigned short");
        equalType.put("uint32", "unsigned long");
        equalType.put("uint64", "unsigned long long");
    }

    private static void collectAllStructs() {
        SymbolNode sn = new SymbolNode();
        sn.setType("struct");
        ArrayList<SymbolNode> allStructs = symbolTable.lookupAll(sn);

        for (SymbolNode snd : allStructs) {
            StructMsg smg = createStructMsg(snd);
            structs.add(smg);
        }
    }

    private static StructMsg createStructMsg(SymbolNode snd) {
        StructMsg smg = new StructMsg();
        String moduleName = (snd.getModuleName() != null) ? snd.getModuleName() : "";
        smg.setName(buildStructName(moduleName, snd.getName()));

        SymbolNode sn = new SymbolNode();
        sn.setStructName("[" + snd.getName() + "]");
        sn.setModuleName(snd.getModuleName());
        smg.setMembers(catchMembers(sn));
        smg.setScopeMembers(catchScopedMembers(sn));
        smg.setHasScoped(!smg.getScopeMembers().isEmpty());
        return smg;
    }

    private static String buildStructName(String moduleName, String name) {
        if (moduleName.isEmpty()) {
            return name;
        } else {
            String modules = Arrays.stream(moduleName.substring(1, moduleName.length() - 1).split(","))
                    .map(String::trim)
                    .collect(Collectors.joining("_"));
            return modules + "_" + name;
        }
    }

    public static ArrayList<MemberMsg> catchMembers(SymbolNode sn) {
        ArrayList<SymbolNode> allMembers = symbolTable.lookupAll(sn);
        ArrayList<MemberMsg> members = new ArrayList<>();
        for (SymbolNode snd : allMembers) {
            if (snd.getType().contains("::")) continue;
            members.add(createMemberMsg(snd));
        }
        return members;
    }

    private static MemberMsg createMemberMsg(SymbolNode snd) {
        MemberMsg member = new MemberMsg();
        String oriType = equalType.getOrDefault(snd.getType(), snd.getType());
        member.setType(capitalizeType(oriType));
        member.setName(snd.getName());
        member.setVal(snd.getVal());
        member.setHasVal(snd.getVal() != null);
        if (snd.getType().startsWith("Array")) {
            setArrayMember(member, snd);
        } else {
            member.setArray(false);
            member.setValNum("0");
        }
        member.setString(snd.getType().contains("string"));
        return member;
    }

    private static void setArrayMember(MemberMsg member, SymbolNode snd) {
        member.setArray(true);
        String arrayType = snd.getType().substring(6, snd.getType().length() - 1);
        member.setType(capitalizeType(arrayType));
        String[] valSplit = snd.getVal().split("#");
        member.setValNum(valSplit[0]);
        member.setVal("{" + String.join(", ", Arrays.copyOfRange(valSplit, 1, valSplit.length)) + "}");
    }

    private static String capitalizeType(String type) {
        return Arrays.stream(type.split("\\s+"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining());
    }

    public static ArrayList<ScopedMemMsg> catchScopedMembers(SymbolNode sn) {
        ArrayList<SymbolNode> allScopedMembers = symbolTable.lookupAll(sn);
        ArrayList<ScopedMemMsg> scopedMembers = new ArrayList<>();
        for (SymbolNode snd : allScopedMembers) {
            if (!snd.getType().contains("::")) continue;
            scopedMembers.add(createScopedMemMsg(snd));
        }
        return scopedMembers;
    }

    private static ScopedMemMsg createScopedMemMsg(SymbolNode snd) {
        ScopedMemMsg scpMember = new ScopedMemMsg();
        String moduleName = snd.getType();
        String[] moduleParts = moduleName.split("::");
        String structName = moduleParts[moduleParts.length - 1];
        String[] moduleNames = moduleParts[0].substring(1, moduleParts[0].length() - 1).split(",");
        String joinedModuleNames = Arrays.stream(moduleNames).map(String::trim).collect(Collectors.joining("_"));
        scpMember.setType(joinedModuleNames + structName);
        scpMember.setName(snd.getName());

        SymbolNode dad = new SymbolNode();
        dad.setModuleName(moduleParts[0]);
        dad.setStructName("[" + structName + "]");
        scpMember.setMembers(catchMembers(dad));
        return scpMember;
    }

    private static void generateHxxFile(String name) throws IOException {
        String result = generateHxxContent(name);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(OUTPUT_FILE_NAME))) {
            bufferedWriter.write(result);
        }
    }

    private static String generateHxxContent(String name) {
        STGroup stg = new STGroupFile("./src/GenCode/Template.stg");
        ST headerST = stg.getInstanceOf("headerTemplate");
        headerST.add("fileName", name);

        ST bodyST = stg.getInstanceOf("bodyTemplate");
        bodyST.add("structs", structs);

        ST footerST = stg.getInstanceOf("footerTemplate");
        footerST.add("fileName", "hxx");

        return headerST.render() + "\n" + bodyST.render() + "\n" + footerST.render() + "\n";
    }
}
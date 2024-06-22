package Semantics;

import G4.MIDLGrammar;
import G4.MIDLGrammarBaseVisitor;
import Symbol.SymbolNode;
import Symbol.SymbolTable;
import Symbol.Error;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 语义分析
 *
 * @author Spring
 * @version 1.0.1
 * @classname Semantics.SemanticAnalyse
 * @date 2024/06/01
 * @see MIDLGrammarBaseVisitor
 */
public class SemanticAnalyse extends MIDLGrammarBaseVisitor<String> {
    public SymbolTable symbolTable = new  SymbolTable();
    public Error error = new Error();
    //当前的module和struct
    private ArrayList<String> currentModule=new ArrayList<String>(); //储存局域模块
    private ArrayList<String> currentStruct=new ArrayList<String>();
    private SymbolNode currentNode = new SymbolNode();
    private ArrayList<String> literalType = new ArrayList<>(); //literal类型

    /**
     * 分析类型
     *
     * @param type
     * @return {@link String }
     */
    public String analyseType(String type){
        String start = "";
        String []types = {"float","double","longdouble", "unsignedshort", "uint16","unsignedlong", "uint32","unsignedlonglong" , "uint64","uint8","short","int16","long","int32","longlong","int64","int8","char", "string", "boolean"};
        int i = 0;
        if(type.startsWith("Array"))
            type=type.substring(6,type.length()-1);

        for(;i < types.length;i++)
            if(types[i].equals(type))
                break;

        if(i <= 2) start = "FLOATING_PT";
        else if(i <= 16) start = "INTEGER";
        else if(i == 17) start = "CHAR";
        else if(i == 18) start = "STRING";
        else if(i == 19) start = "BOOLEAN";
        else start = "SCOPED";
        return start;
    }

    /**
     * specification -> definition { definition }
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public String visitSpecification(MIDLGrammar.SpecificationContext ctx) {
        currentModule.clear();
        currentStruct.clear();
        if(ctx.definition() == null){
            throw new IllegalStateException("Unknown specification context");
        }
        for (int i = 0; i < ctx.getChildCount(); i++) {
            // 访问每个 definition 节点，并将结果添加到 AST 中
            visit(ctx.getChild(i));
        }
        return null;
    }

    /**
     * definiton -> type_decl“;”| module “;”
     *
     * @param ctx ctx
     * @return {@link String }
     */
    @Override
    public String visitDefinition(MIDLGrammar.DefinitionContext ctx){
        // 访问子节点
        visit(ctx.getChild(0));
        return null; // 模块定义后添加分号和换行
    }

    /**
     * 实现module产生式
     * module -> “module”ID “{” definition { definition } “}”
     */
    @Override
    public String visitModule(MIDLGrammar.ModuleContext ctx) {
        SymbolNode node = new SymbolNode();
        node.setName(ctx.ID().getText());
        node.setType("module");
        if(!currentModule.isEmpty()){
            node.setModuleName(currentModule.toString()); // 对于此时的module节点来说它是在currentmodule下的namespace
        }
        else
            node.setModuleName(null); // 无命名空间
        if(symbolTable.lookupSt(node)!=null){
            error.addError(ctx.getStart().getLine()+
                    ":"+ctx.getStart().getCharPositionInLine(),"module",node.getName(),
                    Error.ErrorType.REDEFINED,null,"The module has been defined before.");
        }
        else{
            symbolTable.insertST(node);
        }
        currentModule.add(node.getName());
        // 遍历所有的 definition 节点
        for (MIDLGrammar.DefinitionContext definition : ctx.definition()) {
            visitDefinition(definition);
        }
        currentModule.remove(currentModule.size()-1);
        return null;
    }
    /**
     * type_decl -> struct_type | “struct” ID
     *
     */
    @Override public String visitType_decl(MIDLGrammar.Type_declContext ctx) {
        if(ctx.getChildCount() == 1){
            currentStruct.clear();
            visit(ctx.getChild(0));
        }
        else{
            SymbolNode sn = new SymbolNode();
            sn.setName(ctx.ID().getText());
            sn.setType("struct");
            if(!currentModule.isEmpty()){
                sn.setModuleName(currentModule.toString());
            }
            else {
                sn.setModuleName(null);
            }
            if(!currentStruct.isEmpty()){
                sn.setStructName(currentStruct.toString());
            }
            else {
                sn.setStructName(null);
            }
            SymbolNode result = symbolTable.lookupSt(sn);
            if(result != null){
                error.addError(ctx.getStart().getLine()+":"+
                        ctx.getStart().getCharPositionInLine(),
                        "struct",sn.getName(),Error.ErrorType.REDEFINED,null,"The struct has been defined before.");
            }
            else{
                symbolTable.insertST(sn);
            }
        }
        return null;
    }
    /**
     * struct_type->“struct” ID “{”   member_list “}”
     *
     */
    @Override public String visitStruct_type(MIDLGrammar.Struct_typeContext ctx) {
        SymbolNode node = new SymbolNode();
        node.setName(ctx.ID().getText());
        node.setType("struct");
        if(!currentStruct.isEmpty()){
            node.setStructName(currentStruct.toString());
        }
        else
            node.setStructName(null);
        if(!currentModule.isEmpty()){
            node.setModuleName(currentModule.toString());
        }
        else
            node.setModuleName(null);

        if(symbolTable.lookupSt(node)!=null){
            error.addError(ctx.getStart().getLine()+":"+ctx.getStart().getCharPositionInLine(),"struct",node.getName(),Error.ErrorType.REDEFINED,null,"The struct has been defined before.");
        }
        else{
            symbolTable.insertST(node);
        }
        currentStruct.add(node.getName());
        currentNode.setStructName(node.getStructName());
        currentNode.setModuleName(node.getModuleName());
        visitMember_list(ctx.member_list());
        currentStruct.remove(currentStruct.size()-1);
        return null;
    }
    /**
     * member_list-> { type_spec declarators “;” }
     *
     */
    @Override public String visitMember_list(MIDLGrammar.Member_listContext ctx) {

        // 遍历所有的 type_spec 节点
        List<MIDLGrammar.Type_specContext> typeSpecs = ctx.type_spec();
        List<MIDLGrammar.DeclaratorsContext> declarators = ctx.declarators();

        currentNode.setStructName(currentStruct.toString());
        currentNode.setModuleName(currentModule.toString());
        for (int i = 0; i < typeSpecs.size(); i++) {
            // 添加 type_spec 节点
            visitType_spec(typeSpecs.get(i));
            // 添加 declarators 节点
            visitDeclarators(declarators.get(i));
//            currentNode = new SymbolNode();
        }

        return null;
    }
    /**
     * type_spec -> scoped_name | base_type_spec | struct_type
     *
     */
    @Override public String visitType_spec(MIDLGrammar.Type_specContext ctx) {
        // 如果是 scoped_name，递归调用 visitScoped_name 方法
        visit(ctx.getChild(0));
        return null;
    }
    /**
     * scoped_name -> [“::”] ID {“::” ID }
     *
     */
    @Override public String visitScoped_name(MIDLGrammar.Scoped_nameContext ctx) {
        ArrayList<String> namespaces = new ArrayList<>();
        int i;
        if(ctx.getChild(0).getText().equals("::")){
            i = 1;
        }
        else{
            i = 0;
        }
        for(;i<ctx.getChildCount();i+=2){
            namespaces.add(ctx.getChild(i).getText());
        }
        namespaces.remove(namespaces.size()-1);
        String moduleName = null;
        if(!namespaces.isEmpty()){
            moduleName = namespaces.toString();
            if(moduleName != currentNode.getModuleName()){
                namespaces.add(0,currentNode.getModuleName().substring(1,currentNode.getModuleName().length()-1));
            }
            moduleName = namespaces.toString();
        }else{
            moduleName = currentNode.getModuleName();
        }
        SymbolNode node = new SymbolNode();
        node.setModuleName(moduleName);
        node.setName(ctx.getChild(ctx.getChildCount()-1).getText());
        node.setType("struct");

        SymbolNode result = symbolTable.lookupSt(node);
        String spaces[] = node.getModuleName().split(",");
        for(int k = 0; k < spaces.length;k++){
            spaces[k] = spaces[k].trim();
        }

        List<String> temp = Arrays.asList(spaces);
        ArrayList<String> sp = new ArrayList<>(temp);
        if(sp != null && sp.size() != 1){
            moduleName = null;
            for(int k = 1; k <= sp.size()-2;k++){
                ArrayList<String> temp1 = new ArrayList<>(temp);
                temp1.remove(k);
                moduleName = temp1.toString().substring(1,temp1.toString().length()-1);
                node.setModuleName(moduleName);
                result = symbolTable.lookupSt(node);
                if(result != null) {
                    break;
                }
            }
        }
        if(result==null){
            error.addError(ctx.getStart().getLine()+":"+ctx.getStart().getCharPositionInLine(),"struct",node.getName(),Error.ErrorType.UNDEFINED,null,"The struct has not been defined before.");
        }else{
            currentNode.setType(result.getModuleName() +"::"+ result.getName());

        }
        return null;
    }
    /**
     * base_type_spec->floating_pt_type|integer_type|“char”|“string”|“boolean”
     *
     */
    @Override public String visitBase_type_spec(MIDLGrammar.Base_type_specContext ctx) {
        // 如果是 floating_pt_type，递归调用 visitFloating_pt_type 方法
        if (ctx.floating_pt_type() != null || ctx.integer_type() != null) {
            visit(ctx.getChild(0));
        } else {
            currentNode.setType(ctx.getText());
        }
        return null;

    }

    /**
     * floating_pt_type -> “float” | “double” | “long double”
     *
     */
    @Override public String visitFloating_pt_type(MIDLGrammar.Floating_pt_typeContext ctx) {

        if(ctx.FLOAT() != null || ctx.DOUBLE() != null || ctx.LONG() != null){
            currentNode.setType(ctx.getText());
            return null;
        }
        else {
            // 如果既不是 float 也不是 double 也不是 long double，抛出错误
            throw new IllegalStateException("Unknown floating_pt_type context");
        }
    }
    /**
     * integer_type -> signed_int | unsigned_int
     *
     */
    @Override public String visitInteger_type(MIDLGrammar.Integer_typeContext ctx) {
        visit(ctx.getChild(0));
        return null;
    }
    /**
     *signed_int->(“short”|“int16”)
     * |(“long”|“int32”)
     * |(“long” “long”|“int64”)
     * |“int8”
     */
    @Override public String visitSigned_int(MIDLGrammar.Signed_intContext ctx) {
        currentNode.setType(ctx.getText());
        return null;
    }
    /**
     * unsigned_int -> (“unsigned”“short”| “uint16”)
     *    | (“unsigned”“long”| “uint32”)
     *    | (“unsigned” “long” “long” | “uint64”)
     *    | “uint8”
     */
    @Override public String visitUnsigned_int(MIDLGrammar.Unsigned_intContext ctx) {
        currentNode.setType(ctx.getText());
        return null;
    }
    /**
     * declarators -> declarator {“,” declarator }
     *
     */
    @Override public String visitDeclarators(MIDLGrammar.DeclaratorsContext ctx) {
        // 遍历所有的 declarator 节点
        List<MIDLGrammar.DeclaratorContext> declarators = ctx.declarator();
        for (int i = 0; i < declarators.size(); i++) {
            visitDeclarator(declarators.get(i));
        }
        return null;
    }
    /**
     * declarator -> simple_declarator | array_declarator
     *
     */
    @Override public String visitDeclarator(MIDLGrammar.DeclaratorContext ctx) {
        visit(ctx.getChild(0));
        return null;
    }
    /**
     * simple_declarator -> ID [“=” or_expr]
     *
     */
    @Override public String visitSimple_declarator(MIDLGrammar.Simple_declaratorContext ctx) {
        SymbolNode node = new SymbolNode();
        node.setModuleName(currentNode.getModuleName());
        node.setStructName(currentNode.getStructName());
        node.setName(ctx.ID().getText());
        if(symbolTable.lookupSt(node)!=null){
            error.addError(ctx.getStart().getLine()+":"+ctx.getStart().getCharPositionInLine(),"variable",node.getName(),Error.ErrorType.REDEFINED,null,"The variable has been defined before.");
        }
        else{
            node.setType(currentNode.getType());
            if(ctx.getChildCount() == 1 && node.getType() != null){
                symbolTable.insertST(node);
            }

            else if(ctx.getChildCount() > 1){
                literalType.clear();
                node.setVal(visitOr_expr(ctx.or_expr()));
                if(!isValLegal(node,literalType.getLast())) {
//                    System.out.println("error");
                    error.addError(ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine(), "variable", node.getName(), Error.ErrorType.TYPE_ERROR, node.getType(), "The type of the variable is not consistent with the type of the initial value.");
                }
                else
                    symbolTable.insertST(node);
            }
        }
        return null;
    }

    /**
     * 是否合法
     *
     * @param node        节点
     * @param currentType 电流型
     * @return boolean
     */
    public boolean isValLegal(SymbolNode node,String currentType){
        String result = analyseType(node.getType());

        if(!currentType.equals(result)){
            return false;
        }
        switch (node.getType()){
            case "int8":
                return checkInteger(node.getVal(),8,false);
            case "int16":
            case "short":
                return checkInteger(node.getVal(),16,false);
            case "int32":
            case "long":
                return checkInteger(node.getVal(),32,false);
            case "int64":
            case "longlong":
                return checkInteger(node.getVal(),64,false);
            case "uint8":
                return checkInteger(node.getVal(),8,true);
            case "uint16":
            case "unsignedshort":
                return checkInteger(node.getVal(),16,true);
            case "unsignedlong":
            case "uint32":
                return checkInteger(node.getVal(),32,true);
            case "uint64":
            case "unsignedlonglong":
                return checkInteger(node.getVal(),64,true);
            default:
                return true;
        }

    }

    /**
     * 检查整数
     *
     * @param value  值
     * @param bit    位
     * @param isUint 是uint
     * @return boolean
     */
    public boolean checkInteger(String value,int bit,boolean isUint){
        int val = Integer.parseInt(value);
        if(!isUint){
            double temp = val + Math.pow(2,bit);
            int temp2 = (int)temp;
            return checkInteger(Integer.toString(temp2),bit,true);

        }
        int base = (int)Math.pow(2,8);
        switch (bit){
            case 8:
                if(val > base*2) return false;
                return true;
            case 16:
                if(val > base*base*2) return false;
                return true;
            case 32:
                if(val > Math.pow(base,4)*2) return false;
                return true;
            case 64:
                if(val > Math.pow(base,8)*2) return false;
                return true;
            default:
                return false;
        }
    }

    /**
     * array_declarator -> ID “[” or_expr “]” [“=” exp_list ]
     *
     * @param ctx ctx
     * @return {@link String }
     */
    @Override public String visitArray_declarator(MIDLGrammar.Array_declaratorContext ctx) {
        SymbolNode sn=new SymbolNode();
        sn.setName(ctx.getChild(0).getText());
        sn.setStructName(currentNode.getStructName());
        sn.setModuleName(currentNode.getModuleName());
        SymbolNode res= symbolTable.lookupSt(sn);

        if(res!=null)
            error.addError(ctx.getStart().getLine()+":"+ctx.getStart().getCharPositionInLine(),currentNode.getType(),ctx.getChild(0).getText(), Error.ErrorType.REDEFINED,null,null);
        else{
            sn.setType("Array<"+currentNode.getType()+">");

        }

        if(res==null){
            sn.setVal(visit(ctx.getChild(2)));
            if(!isValLegal(sn,literalType.getLast())) {
                error.addError(ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine(), "Array", sn.getName(), Error.ErrorType.TYPE_ERROR, null, "The type of the variable is not consistent with the type of the initial value.");
            }
            else {
                symbolTable.insertST(sn);
                if(ctx.getChildCount() > 4){
                    String val = visit(ctx.getChild(5));
                    String valList[] = val.split(",");
                    if(valList.length-1 > Integer.parseInt(sn.getVal()))
                        error.addError(ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine(), "Array", sn.getName(), Error.ErrorType.OVERFLOW, null, "The number of initial values is greater than the array size.");

                    for(int i = 1; i < valList.length; i ++){
                        SymbolNode node = new SymbolNode();
                        node.setName(sn.getName());
                        node.setType(sn.getType());
                        node.setModuleName(sn.getModuleName());
                        node.setStructName(sn.getStructName());
                        String lists[] = valList[i].split(":");
                        node.setVal(lists[0]);
                        if(!isValLegal(node,lists[1]))
                            error.addError(ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine(), "Array", node.getName(), Error.ErrorType.TYPE_ERROR, null, "The type of the variable is not consistent with the type of the initial value.");
                        else {
                            sn.setNext(node);
                            sn = node;
                            if(i == ctx.getChildCount() - 1)
                                sn.setNext(null);
                        }
                    }
                }
            }

        }
        return null;
    }


    /**
     * exp_list -> “[” or_expr { “,”or_expr } “]”
     *
     */
    @Override public String visitExp_list(MIDLGrammar.Exp_listContext ctx) {
        int n = ctx.getChildCount();
        String result = "";
        for (int i = 1; i < n; i +=2){
            literalType.clear();
            result = result +","+ visit(ctx.getChild(i)) + ":" + literalType.getLast();
        }

        return result;
    }
    /**
     * or_expr -> xor_expr {“|” xor_expr }
     *
     */
    @Override public String visitOr_expr(MIDLGrammar.Or_exprContext ctx) {
        int n = ctx.getChildCount();
        String result;
        if(n > 1) {
            String preVal = visit(ctx.getChild(0));
            for (int i = 1; i <= n; i += 2) {
                String nextVal = visit(ctx.getChild(i + 1));
                preVal = Calculator.caluatorAns(preVal,nextVal,"|",literalType,i-1,i);
            }
            result = preVal;
        }
        else result = visit(ctx.getChild(0));
        return result;
    }
    /**
     * xor_expr -> and_expr {“^” and_expr }
     *
     */
    @Override public String visitXor_expr(MIDLGrammar.Xor_exprContext ctx) {
        int n = ctx.getChildCount();
        String result;
        if(n > 1) {
            String preVal = visit(ctx.getChild(0));
            for (int i = 1; i <= n; i += 2) {
                String nextVal = visit(ctx.getChild(i + 1));
                preVal = Calculator.caluatorAns(preVal,nextVal,"^",literalType,i-1,i);
            }
            result = preVal;
        }
        else result = visit(ctx.getChild(0));
        return result;

    }
    /**
     * and_expr -> shift_expr {“&”shift_expr }
     *
     */
    @Override public String visitAnd_expr(MIDLGrammar.And_exprContext ctx) {
        int n = ctx.getChildCount();
        String result;
        if(n > 1) {
            String preVal = visit(ctx.getChild(0));
            for (int i = 1; i <= n; i += 2) {
                String nextVal = visit(ctx.getChild(i + 1));
                preVal = Calculator.caluatorAns(preVal,nextVal,"&",literalType,i-1,i);
            }
            result = preVal;
        }
        else result = visit(ctx.getChild(0));
        return result;
    }
    /**
     * shift_expr -> add_expr { ( “<<” | “>>” ) add_expr }
     */
    @Override public String visitShift_expr(MIDLGrammar.Shift_exprContext ctx) {
        int n = ctx.getChildCount();
        String result;
        if(n > 1) {
            String preVal = visit(ctx.getChild(0));
            for (int i = 1; i <= n; i += 2) {
                String nextVal = visit(ctx.getChild(i + 1));
                preVal = Calculator.caluatorAns(preVal,nextVal,ctx.getChild(i).getText(),literalType,i-1,i);
            }
            result = preVal;
        }
        else result = visit(ctx.getChild(0));
        return result;
    }
    /**
     * add_expr -> mult_expr { (“+” | “-”) mult_expr }
     *
     */
    @Override public String visitAdd_expr(MIDLGrammar.Add_exprContext ctx) {
        int n = ctx.getChildCount();
        String result;
        if(n > 1) {
            String preVal = visit(ctx.getChild(0));
            for (int i = 1; i <= n; i += 2) {
                String nextVal = visit(ctx.getChild(i + 1));
                preVal = Calculator.caluatorAns(preVal,nextVal,ctx.getChild(i).getText(),literalType,i-1,i+1);
            }
            result = preVal;
        }
        else result = visit(ctx.getChild(0));
        return result;
    }
    /**
     * mult_expr -> unary_expr { (“*” |“/”|“%”) unary_expr }
     *
     */
    @Override public String visitMult_expr(MIDLGrammar.Mult_exprContext ctx) {
        int n = ctx.getChildCount();
        String result;
        if(n > 1) {
            String preVal = visit(ctx.getChild(0));
            for (int i = 1; i <= n; i += 2) {
                String nextVal = visit(ctx.getChild(i + 1));
                preVal = Calculator.caluatorAns(preVal,nextVal,ctx.getChild(i).getText(),literalType,i-1,i+1);
            }
            result = preVal;
        }
        else result = visit(ctx.getChild(0));
        return result;
    }
    /**
     * unary_expr -> [“-”| “+” | “~”] literal
     *
     */
    @Override public String visitUnary_expr(MIDLGrammar.Unary_exprContext ctx) {
        if(ctx.getChildCount() != 1){
            String literal = visit(ctx.getChild(1));
            String[] literals = literal.split(":");
            literalType.add(literals[0]);
            return Calculator.caluatorAns(literal,ctx.getChild(0).getText(),literals[0]);
        }
        else{
            String literal = visit(ctx.getChild(0));
            String[] literals = literal.split(":");
            literalType.add(literals[0]);
            return literals[1];
        }
    }
    /**
     * literal -> INTEGER | FLOATING_PT | CHAR | STRING | BOOLEAN
     *
     */
    @Override public String visitLiteral(MIDLGrammar.LiteralContext ctx) {

        if(ctx.INTEGER()!=null){
            return "INTEGER:"+ctx.INTEGER().getText();
        }
        else if(ctx.FLOATING_PT()!=null){
            return "FLOATING_PT:"+ctx.FLOATING_PT().getText();
        }
        else if(ctx.CHARRegular()!=null){
            return "CHAR:"+ctx.CHARRegular().getText();
        }
        else if(ctx.STRINGRegular()!=null){
            return "STRING:"+ctx.STRINGRegular().getText();
        }
        else if(ctx.BOOLEANRegular()!=null){
            return "BOOLEAN:"+ctx.BOOLEANRegular().getText();
        }
        return null;
    }



}

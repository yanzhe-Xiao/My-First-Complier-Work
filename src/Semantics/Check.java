package Semantics;


import G4.MIDLGrammar;
import G4.MIDLLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

/**
 * 整合前端
 * 词法-语法-语义
 */
public class Check {

    public static final String inputFileName = "./input/GenCode/case2/struct_nest.idl";
    public static SemanticAnalyse semanticChecker;
    public static String getLineByText(String text, int lineNumber) {
        // 将文本按行分割
        String[] lines = text.split("\n", -1); // 使用-1作为限制，以包含所有结果

        // 检查行号是否有效
        if (lineNumber < 1 || lineNumber > lines.length) {
            return null; // 如果行号超出范围，返回null
        }

        // 返回所需的行
        return lines[lineNumber - 1].trim(); // 数组索引从0开始，所以需要减1
    }

    public static void check() throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFileName));
        StringBuilder codes= new StringBuilder();
        String line;

        int cnt = 1;
        while((line = bufferedReader.readLine()) != null) {

            System.out.printf("[%03d]: %s",cnt,line);
            System.out.println();
            codes.append(line).append("\n");
            cnt++;
        }

        //词法检查-语法检查
        CharStream input = CharStreams.fromString(codes.toString());
        MIDLLexer lexer = new MIDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MIDLGrammar parser = new MIDLGrammar(tokens);
        ParseTree tree = parser.specification();

        //遍历分析树-语义检查
        semanticChecker = new SemanticAnalyse();
        semanticChecker.visit(tree);
        //打印符号表
        System.out.println("========================SymbolTable========================");
        System.out.println(semanticChecker.symbolTable.toString());
        System.out.println("===========================================================");
        bufferedReader.close();
        if(semanticChecker.error.getLineInfo() == null) {
            System.out.println("No Error");
            return;
        }
        //打印错误信息
        System.err.println("======================Errors TraceBack=====================");
        String err;
        String errorLine = semanticChecker.error.getLineInfo();
        String info[] = errorLine.split(":");
        int lineNum = Integer.parseInt(info[0]);
        int pos = Integer.parseInt(info[1]);
        err = getLineByText(codes.toString(),lineNum);
        System.err.println("Error Line: " + errorLine);

        System.err.println(err);
        for (int i = 1; i < pos; i++) {
            System.err.print(" ");
        }
        System.err.println("▲\n");
        System.err.println(semanticChecker.error.getErrString());
        System.err.println("===========================================================");
        System.out.println();




    }

    public static void main(String[] args) throws IOException {
        check();
    }
}

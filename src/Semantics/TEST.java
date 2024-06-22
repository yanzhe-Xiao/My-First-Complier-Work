package Semantics;

import G4.MIDLGrammar;
import G4.MIDLLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class TEST {
    public static void main(String[] args) {
        String input = "struct a{int8 x = 2;int8 a[2]=[1,2,3];};";
        CharStream stream = CharStreams.fromString(input);

        // Create a lexer that feeds off of input CharStream
        MIDLLexer lexer = new MIDLLexer(stream);
        // Create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Create a parser that feeds off the tokens buffer
        MIDLGrammar parser = new MIDLGrammar(tokens);
        ParseTree tree = parser.specification();
        SemanticAnalyse semanticAnalyse = new SemanticAnalyse();
        semanticAnalyse.visit(tree);
//        System.out.println(semanticAnalyse.symbolTable.toString());
        System.out.println(semanticAnalyse.error.getErrString());
    }
}

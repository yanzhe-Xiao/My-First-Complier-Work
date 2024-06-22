package MIDL_AST;
import G4.MIDLLexer;
import G4.MIDLGrammar;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class TEST {


    public static void main(String[] args) {
        String input = "struct A{a::b c};";
        CharStream stream = CharStreams.fromString(input);

        // Create a lexer that feeds off of input CharStream
        MIDLLexer lexer = new MIDLLexer(stream);
        // Create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Create a parser that feeds off the tokens buffer
        MIDLGrammar parser = new MIDLGrammar(tokens);
        ParseTree tree = parser.specification();
        Format_AST format = new Format_AST();
        format.visit(tree);
        System.out.println(format.getAST());
    }
}

package genCode;
import org.stringtemplate.v4.ST;

public class TEST {
    public static void main(String[] args) {
        ST hello = new ST("Hello, <name>");
        hello.add("name", "World");
        System.out.println(hello.render());

    }
}

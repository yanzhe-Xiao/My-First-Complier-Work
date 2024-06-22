package Symbol;

/*
    * SymbolNode class is used to create a node for the symbol table
 */
public class SymbolNode {
    private String name; //name of the symbol
    private String type; //type of the symbol if the type belongs struct, the value will include struct's namespace
    private String moduleName; // namespace of current node
    private String structName; // name of current struct, different from type
    private String val; // value
    private SymbolNode next;
    public SymbolNode()
    {
        this.name =null;
        this.type = null;
        this.moduleName = null;
        this.structName = null;
        this.val = null;
        this.next = null;
    }

    public SymbolNode(String name, String type, String moduleName, String structName, String val, SymbolNode next) {
        this.name = name;
        this.type = type;
        this.moduleName = moduleName;
        this.structName = structName;
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString(){
        return "Module:"+this.moduleName+" | "+"Struct:"+ this.structName+" | "+"Type:"+ this.type
                +" | "+ "Name:"+this.name+" | "+ "Val:"+this.val;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getVal() {
        return val;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getStructName() {
        return structName;
    }

    public SymbolNode getNext() {
        return next;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModuleName(String moduleNAme) {
        this.moduleName = moduleNAme;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStructName(String structName) {
        this.structName = structName;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void setNext(SymbolNode next) {
        this.next = next;
    }
}

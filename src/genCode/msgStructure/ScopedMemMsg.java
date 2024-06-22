package genCode.msgStructure;

import java.util.ArrayList;

/**
 * 外来引用的成员信息体
 */
public class ScopedMemMsg {
    String name;
    String type;
    ArrayList<MemberMsg> members;

    public ScopedMemMsg() {

    }

    public ScopedMemMsg(String name, String type,ArrayList<MemberMsg> members) {
        this.name = name;
        this.type = type;
        this.members = members;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(ArrayList<MemberMsg> members) {
        this.members = members;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public ArrayList<MemberMsg> getMembers() {
        return members;
    }
}

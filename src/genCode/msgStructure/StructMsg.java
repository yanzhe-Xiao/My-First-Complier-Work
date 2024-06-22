package genCode.msgStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 总struct结构信息
 */
public class StructMsg {
    private String name;
    private List<MemberMsg> members;
    private List<ScopedMemMsg> scopeMembers;
    private boolean hasScoped;

    public StructMsg(String name, List<MemberMsg> members, List<ScopedMemMsg> scopeMembers, boolean hasScoped) {
        this.name = name;
        this.members = members;
        this.scopeMembers = scopeMembers;
        this.hasScoped = hasScoped;
    }

    public StructMsg() {
        this.name = "";
        this.members = new ArrayList<>();
        this.scopeMembers = new ArrayList<>();
        this.hasScoped = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberMsg> getMembers() {
        return members;
    }

    public void setMembers(List<MemberMsg> members) {
        this.members = members;
    }

    public List<ScopedMemMsg> getScopeMembers() {
        return scopeMembers;
    }

    public void setScopeMembers(List<ScopedMemMsg> scopeMembers) {
        this.scopeMembers = scopeMembers;
    }

    public boolean hasScoped() {
        return hasScoped;
    }

    public void setHasScoped(boolean hasScoped) {
        this.hasScoped = hasScoped;
    }
}
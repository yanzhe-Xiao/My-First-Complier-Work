package Symbol;

import java.util.ArrayList;

/**
 * 符号列表
 *
 * @author Spring
 * @version 1.0.1
 * @classname Symbol.SymbolList
 * @date 2024/06/02
 */
public class SymbolList {
    private SymbolNode head;

    public SymbolList() {
        head = new SymbolNode(); // 初始化哑元节点
    }

    /**
     * 头插法插入节点。
     * @param sn 新节点
     */
    public void insertAtHead(SymbolNode sn) {
        if (sn == null) {
            throw new IllegalArgumentException("Cannot insert null node.");
        }
        sn.setNext(head.getNext());
        head.setNext(sn);
    }

    public SymbolNode getHead() {
        return head;
    }

    /**
     * 查找匹配的第一个节点。
     * @param toFind 查找条件
     * @return 匹配的节点，如果没有找到则返回null
     */
    public SymbolNode findFirstMatchingNode(SymbolNode toFind) {
        SymbolNode tp = head;
        while((tp=tp.getNext())!=null){
            if(toFind.getName()!=null && !(toFind.getName().equals(tp.getName())))
                continue;
            if(toFind.getModuleName()!=null && !(toFind.getModuleName().equals(tp.getModuleName()))){
                continue;
            }
            if(toFind.getStructName()!=null && !(toFind.getStructName().equals(tp.getStructName())))
                continue;
            if(toFind.getType()!=null && !(toFind.getType().equals(tp.getType())))
                continue;
            if(toFind.getVal()!=null && !(toFind.getVal().equals(tp.getVal())))
                continue;
            break;
        }
        return tp;
    }

    /**
     * 查找所有匹配的节点。
     * @param toFind 查找条件
     * @return 匹配的节点列表
     */
    public ArrayList<SymbolNode> findAllMatchingNodes(SymbolNode toFind) {
        ArrayList<SymbolNode> ans = new ArrayList<SymbolNode>();

        SymbolNode tp = head;
        while((tp=tp.getNext())!=null){
            if(toFind.getName()!=null && !(toFind.getName().equals(tp.getName())))
                continue;
            if(toFind.getModuleName()!=null && !(toFind.getModuleName().equals(tp.getModuleName())))
                continue;
            if(toFind.getStructName()!=null && !(toFind.getStructName().equals(tp.getStructName())))
                continue;
            if(toFind.getType()!=null && !(toFind.getType().equals(tp.getType())))
                continue;
            if(toFind.getVal()!=null && !(toFind.getVal().equals(tp.getVal())))
                continue;
            ans.add(tp);
        }
        return ans;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SymbolNode current = head.getNext();
        while (current != null) {
            sb.append(current.toString()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}
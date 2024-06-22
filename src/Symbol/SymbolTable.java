package Symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class SymbolTable {
    private static final int SIZE = 211;
    private SymbolList[] symTable;

    /**
     * 输入字符串，输出哈希值。
     *
     * @param key 输入的字符串
     * @return 计算得到的哈希值
     */
    public static int hash(String key) {
        int hashCode = 1;
        for (int i = 0; i < key.length(); i++) {
            hashCode = (hashCode * 31 + key.charAt(i)) % SIZE; // 立即应用模运算
        }
        return hashCode;
    }

    public SymbolTable() {
        symTable = new SymbolList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            symTable[i] = new SymbolList();
        }
    }

    /**
     * 将属性信息插入符号表。
     *
     * @param sn 要插入的SymbolNode
     */
    public void insertST(SymbolNode sn) {
        int hashCode = hash(sn.getName());
        SymbolList sl = symTable[hashCode];

        //该位置还没链表
        if(sl==null)
        {
            sl = new SymbolList();
            sl.insertAtHead(sn);
        }
        else
        {
            sl.insertAtHead(sn);
        }
        symTable[hashCode] = sl;
    }

    /**
     * 查找符合要求的节点，带姓名。
     *
     * @param sn 查找条件
     * @return 匹配的SymbolNode，如果没有找到则返回null
     */
    public SymbolNode lookupSt(SymbolNode sn) {
        if ((sn == null || sn.getName() == null) && sn.getModuleName() == null) {
            return null;
        }
        if(sn.getModuleName() != null && sn.getName() == null){
            String name[] = sn.getModuleName().split("::");
            int n = name.length;

            while(n>0){
                if(symTable[hash(name[--n])].findFirstMatchingNode(sn)==null){
                    return null;
                }
            }

        }
        int hashCode = hash(sn.getName());
        return symTable[hashCode].findFirstMatchingNode(sn);
    }

    /**
     * 查找所有符合要求的节点。
     *
     * @param sn 查找条件
     * @return 所有匹配的SymbolNode列表
     */
    public ArrayList<SymbolNode> lookupAll(SymbolNode sn) {
        if (sn == null) {
            return new ArrayList<>();
        }
        ArrayList<SymbolNode> ans = new ArrayList<>();
        for (SymbolList sl : symTable) {
            if (sl != null) {
                ans.addAll(sl.findAllMatchingNodes(sn));
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (SymbolList sl : symTable) {
            if (sl != null && !Objects.equals(sl.toString(), "")) {
                sb.append(sl.toString()).append("\n");
            }
        }
        return sb.toString();
    }

//    public static void main(String[] args) throws IOException {
//        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
//            String line;
//            while ((line = bf.readLine()) != null) {
//                int value = hash(line);
//                System.out.println(value);
//            }
//        }
//    }
}
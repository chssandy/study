package com.wicket.algorithm.ac;

/**
 * @Copyright: com.wicket
 * @ProjectName: study
 * @Package: com.wicket.algorithm.ac
 * @ClassName: Trie
 * @Description: Trie前缀树
 * @Author: CHS
 * @Date: 2023/6/19 13:18
 */
public class Trie {
    /*
        trie根节点
     */
    private AcNode root;

    /*
        加入模式串，构建Trie
        @param word 模式串，非空
     */
    public void insert(String word){
        AcNode cur = root;
        for(char c : word.toCharArray()){
            if(!cur.next.containsKey(c)){
                cur.next.put(c,new AcNode());
            }
            cur = cur.next.get(c);
        }
        cur.depth = word.length();
    }
}

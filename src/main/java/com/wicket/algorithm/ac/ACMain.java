package com.wicket.algorithm.ac;

/**
 * @Copyright: com.wicket
 * @ProjectName: study
 * @Package: com.wicket.algorithm.ac
 * @ClassName: ACMain
 * @Description: 主函数
 * @Author: CHS
 * @Date: 2023/6/19 14:15
 */
public class ACMain {
    public static void main(String[] args) {
        ACTrie acTrie = new ACTrie();
        acTrie.insert("最");
        acTrie.insert("电焊");
        acTrie.insert("电焊工");
        acTrie.insert("电焊工人");
        acTrie.insert("电焊学员");
        acTrie.insert("电焊学徒");
        acTrie.insert("电焊学徒工");
        acTrie.insert("普通电焊工");
        acTrie.insert("普通电商");
        acTrie.insert("普工");
        // 构建fail指针，一个bfs遍历
        acTrie.buildFailurePointer();
        System.out.println(acTrie.parseText("你好，我最想找一个普通电焊工相关的工作"));
    }
}

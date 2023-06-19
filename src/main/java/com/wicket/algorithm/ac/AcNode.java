package com.wicket.algorithm.ac;

import java.util.HashMap;
import java.util.Map;

/**
 * @Copyright: com.wicket
 * @ProjectName: study
 * @Package: com.wicket.algorithm.ac
 * @ClassName: AcNode
 * @Description: 节点定义
 * @Author: CHS
 * @Date: 2023/6/19 11:41
 */
public class AcNode {
    /*
        经过该节点的模式串的下层节点
     */
    Map<Character,AcNode> next = new HashMap<>();

    /*
        模式串的长度，也是节点的深度
     */
    int depth;

    /*
        适配指针，如果没有匹配到，则跳转至此状态
     */
    AcNode failure;

    public boolean hashNext(char nextKey){
        return next.containsKey(nextKey);
    }

    public AcNode getNext(char nextKey){
        return next.get(nextKey);
    }
}

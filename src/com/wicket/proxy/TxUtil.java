package com.wicket.proxy;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname TxUtil
 * @description TODO
 * @date 2020/8/26 11:37
 */
public class TxUtil {
    //第一个拦截器方法：模拟事务开始
    public void beginTx(){
        System.out.println("==模拟开始事务==");
    }
    //第二个拦截器方法：模式事务结束
    public void endTx(){
        System.out.println("==模拟结束事务==");
    }
}

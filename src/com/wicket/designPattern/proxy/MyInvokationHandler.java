package com.wicket.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MyInvokationHandler
 * @description TODO
 * @date 2020/8/26 11:39
 */
public class MyInvokationHandler implements InvocationHandler {

    //需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TxUtil tx = new TxUtil();
        tx.beginTx();

        Object result = method.invoke(target,args);
        tx.endTx();
        return result;
    }
}

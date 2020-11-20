package com.wicket.designPattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MyProxyFactory
 * @description TODO
 * @date 2020/8/26 11:41
 */
public class MyProxyFactory {

    //为指定target生成动态代理对象
    public static Object getProxy(Object target) throws Exception{
        //创建一个MyInvokationHandler对象
        MyInvokationHandler handler = new MyInvokationHandler();

        //为MyInvokationHandler设置target对象
        handler.setTarget(target);
        //创建并返回一个动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader() , target.getClass().getInterfaces(),handler);
    }
}

package com.wicket.designPattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname CGLIBProxyExample
 * @description TODO
 * @date 2021/7/1 13:55
 */
public class CGLIBProxyExample {
    static class Car{
        public  void run(){
            System.out.println("The car is running.");
        }
    }

    /**
     * CGLib 代理类
     */
    static class CGLibProxy implements MethodInterceptor{

        private Object target; //代理对象

        public Object getInstance(Object target){
            this.target = target;
            Enhancer enhancer = new Enhancer();
            //设置父类为实例类
            enhancer.setSuperclass(this.target.getClass());
            //回调方法
            enhancer.setCallback(this);
            //创建代理对象
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("cglib 动态代理之前的业务处理");
            Object result = methodProxy.invokeSuper(o,objects);

            return result;
        }
    }

    /**
     * 执行 CGLib 的方法调用
     * @param args
     */
    public static void main(String[] args) {
        //创建cglib代理类
        CGLibProxy  proxy = new CGLibProxy();
        Car car = (Car) proxy.getInstance(new Car());
        car.run();
    }
}

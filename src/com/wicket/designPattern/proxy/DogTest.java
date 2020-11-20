package com.wicket.designPattern.proxy;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname DogTest
 * @description TODO
 * @date 2020/8/26 11:46
 */
public class DogTest {
    public static void main(String[] args) throws Exception{
        //创建一个原始的Gundog对象，作为target
        Dog target = new GunDog();
        target.info();
        target.run();
        //以指定的target来创建动态代理
        Dog dog = (Dog) MyProxyFactory.getProxy(target);

        dog.info();
        dog.run();

    }
}

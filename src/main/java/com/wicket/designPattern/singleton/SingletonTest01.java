package com.wicket.designPattern.singleton;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SingletonTest01
 * @description TODO
 * @date 2022/6/25 23:15
 */
public class SingletonTest01{
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton1_1 = Singleton1.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton1_1.hashCode());
    }
}
// 饿汉式（静态变量）
class Singleton1 {
    //构造器私有化，防止外部new
    private Singleton1(){

    }
    //本类内部创建对象实例
    private final static Singleton1 instance = new Singleton1();
    //对外提供一个公有的静态方法，返回实例对象
    public static Singleton1 getInstance(){
        return instance;
    }
}

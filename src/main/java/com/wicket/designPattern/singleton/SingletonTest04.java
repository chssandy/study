package com.wicket.designPattern.singleton;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SingletonTest04
 * @description TODO
 * @date 2022/6/25 24:15
 */
public class SingletonTest04{
    public static void main(String[] args) {
        Singleton4 singleton2 = Singleton4.getInstance();
        Singleton4 singleton2_1 = Singleton4.getInstance();
        System.out.println(singleton2);
        System.out.println(singleton2.hashCode());
        System.out.println(singleton2_1.hashCode());

    }
}

// 懒汉式(线程安全，同步方法)
class Singleton4 {
    //本类内部创建对象实例
    private static Singleton4 instance ;
    //构造器私有化，防止外部new
    private Singleton4(){}

    //对外提供一个公有的静态方法，返回实例对象
    public static synchronized Singleton4 getInstance(){
        if(instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}

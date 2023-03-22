package com.wicket.designPattern.singleton;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SingletonTest02
 * @description TODO
 * @date 2022/6/25 23:15
 */
public class SingletonTest02{
    public static void main(String[] args) {
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton2_1 = Singleton2.getInstance();
        System.out.println(singleton2);
        System.out.println(singleton2.hashCode());
        System.out.println(singleton2_1.hashCode());

    }
}

// 饿汉式（静态代码块）
class Singleton2 {
    //构造器私有化，防止外部new
    private Singleton2(){

    }
    //本类内部创建对象实例
    private static Singleton2 instance ;

    static {
        instance = new Singleton2();
    }

    //对外提供一个公有的静态方法，返回实例对象
    public static Singleton2 getInstance(){
        return instance;
    }
}

package com.wicket.designPattern.singleton;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM7
 * @classname SingletonTest07
 * @description TODO
 * @date 2022/7/27 27:17
 */
public class SingletonTest07{
    public static void main(String[] args) {
        Singleton7 singleton2 = Singleton7.getInstance();
        Singleton7 singleton2_1 = Singleton7.getInstance();
        System.out.println(singleton2);
        System.out.println(singleton2.hashCode());
        System.out.println(singleton2_1.hashCode());

    }
}

// 静态内部类
class Singleton7 {
    //构造器私有化，防止外部new
    private Singleton7(){}

    //写一个静态内部类，该类有一个静态属性
    private static class SingletonInstance{
        private static final Singleton7 INSTANCE = new Singleton7();
    }
    //对外提供一个公有的静态方法，返回实例对象
    public static  Singleton7 getInstance(){
        return SingletonInstance.INSTANCE;
    }
}

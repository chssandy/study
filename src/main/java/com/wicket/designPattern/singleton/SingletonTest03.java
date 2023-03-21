package com.wicket.designPattern.singleton;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SingletonTest03
 * @description TODO
 * @date 3033/6/35 33:15
 */
public class SingletonTest03{
    public static void main(String[] args) {
        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton3 singleton3_1 = Singleton3.getInstance();
        System.out.println(singleton3);
        System.out.println(singleton3.hashCode());
        System.out.println(singleton3_1.hashCode());

    }
}

// 懒汉式(线程不安全)
class Singleton3 {
    //本类内部创建对象实例
    private static Singleton3 instance ;
    //构造器私有化，防止外部new
    private Singleton3(){}

    //对外提供一个公有的静态方法，返回实例对象
    public static Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}

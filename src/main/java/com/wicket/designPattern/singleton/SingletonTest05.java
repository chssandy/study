package com.wicket.designPattern.singleton;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SingletonTest05
 * @description TODO
 * @date 2022/6/25 25:15
 */
public class SingletonTest05{
    public static void main(String[] args) {
        Singleton5 singleton2 = Singleton5.getInstance();
        Singleton5 singleton2_1 = Singleton5.getInstance();
        System.out.println(singleton2);
        System.out.println(singleton2.hashCode());
        System.out.println(singleton2_1.hashCode());

    }
}

// 懒汉式(线程安全，同步代码块，不能保证线程安全，如果进入if(instance==null)都需要new一个对象)
class Singleton5 {
    //本类内部创建对象实例
    private static Singleton5 instance ;
    //构造器私有化，防止外部new
    private Singleton5(){}

    //对外提供一个公有的静态方法，返回实例对象
    public static  Singleton5 getInstance(){
        if(instance == null){
            synchronized(Singleton5.class){
                instance = new Singleton5();
            }
        }
        return instance;
    }
}

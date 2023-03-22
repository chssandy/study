package com.wicket.designPattern.singleton;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM6
 * @classname SingletonTest06
 * @description TODO
 * @date 2022/6/26 26:16
 */
public class SingletonTest06{
    public static void main(String[] args) {
        Singleton6 singleton2 = Singleton6.getInstance();
        Singleton6 singleton2_1 = Singleton6.getInstance();
        System.out.println(singleton2);
        System.out.println(singleton2.hashCode());
        System.out.println(singleton2_1.hashCode());

    }
}

// 双重检查(线程安全，加入双重检查代码，解决了线程安全，解决了懒加载问题，同时保证效率
class Singleton6 {
    //本类内部创建对象实例
    private static volatile Singleton6 instance ;
    //构造器私有化，防止外部new
    private Singleton6(){}

    //对外提供一个公有的静态方法，返回实例对象
    public static  Singleton6 getInstance(){
        if(instance == null){
            synchronized(Singleton6.class){
                if(instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}

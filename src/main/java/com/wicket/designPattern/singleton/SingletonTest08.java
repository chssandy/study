package com.wicket.designPattern.singleton;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM8
 * @classname SingletonTest08
 * @description TODO
 * @date 2022/8/28 28:18
 */
public class SingletonTest08{
    public static void main(String[] args) {
        Singleton8 singleton8 = Singleton8.INSTANCE;
        Singleton8 singleton8_1 = Singleton8.INSTANCE;
        System.out.println(singleton8);
        System.out.println(singleton8.hashCode());
        System.out.println(singleton8_1.hashCode());

    }
}

// 枚举，实现单例
enum Singleton8 {
    INSTANCE;
    public void sayOK(){
        System.out.println("ok");
    }
}

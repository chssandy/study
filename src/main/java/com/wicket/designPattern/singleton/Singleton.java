package com.wicket.designPattern.singleton;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Singleton
 * @description TODO
 * @date 2020/8/26 9:40
 */
public class Singleton {
    //使用一个类变量缓存曾经创建的实例
    private static Singleton instance;
    // 将构造器使用private修饰，隐藏该构造器
    private Singleton(){}
    //提供一个静态方法，用于返回Singleton实例
    //该方法可以加入自定义的控制，保证只产生一个Singleton对象
    public static Singleton getInstance(){
        //如果instance为null，表明不曾创建Singleton对象
        //如果instance不为null，则表明已创建了Singleton对象，将不会执行该方法
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}

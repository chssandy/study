package com.wicket.jvm;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SubClass
 * @description 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * @date 2020/10/15 9:50
 */
public class SubClass extends SuperClass {
    static{
        System.out.println("SubClass init!");
    }
}

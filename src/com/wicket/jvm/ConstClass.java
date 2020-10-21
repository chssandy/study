package com.wicket.jvm;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname ConstClass
 * @description TODO
 * @date 2020/10/15 9:57
 */
public class ConstClass {
    static{
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}

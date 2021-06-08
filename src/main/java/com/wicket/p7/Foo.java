package com.wicket.p7;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Foo
 * @description TODO
 * @date 2020/9/24 15:08
 */
public class Foo {

    static boolean flag;
    public static void main(String[] args) {
        flag = true;
        if(flag) System.out.println("1");
        if(flag == true) System.out.println("2");

    }
}

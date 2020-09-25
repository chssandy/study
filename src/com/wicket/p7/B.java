package com.wicket.p7;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname B
 * @description TODO
 * @date 2020/9/24 14:40
 */
public class B {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        a3 = a1;
        a1 = a2;
        a2 = null;
        a3 = a1;
    }
}

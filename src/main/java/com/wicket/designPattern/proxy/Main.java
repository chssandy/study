package com.wicket.designPattern.proxy;


/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Main
 * @description TODO
 * @date 2020/8/26 9:48
 */
public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Image image = new ImageProxy(null);
        System.out.println("系统得到Image对象的时间开销："+ (System.currentTimeMillis() - start));
        image.show();
    }
}

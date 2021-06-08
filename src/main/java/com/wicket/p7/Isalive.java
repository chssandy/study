package com.wicket.p7;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Isalive
 * @description 需要配置参数 ： -XX:printGC
 * @date 2020/9/24 15:34
 */
public class Isalive {
    public Object instance = null;

    //占据10M内存，便于判断分析GC
    private byte[] bigSize = new byte[10*1024*1024];

    public static void main(String[] args) {
        Isalive objectA = new Isalive();
        Isalive objectB = new Isalive();

        objectA.instance = objectB;
        objectB.instance = objectA;

        objectA = null;
        objectB = null;
        System.gc();
    }

}

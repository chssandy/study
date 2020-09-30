package com.wicket.distributed;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Test
 * @description TODO
 * @date 2020/9/27 12:12
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024/1024);
    }
}

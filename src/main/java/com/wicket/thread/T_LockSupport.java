package com.wicket.thread;

import java.util.concurrent.locks.LockSupport;

/**
 *  用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C...26Z
 *  优解
 */
public class T_LockSupport {
    static Thread t1 = null ,t2 = null;

    public static void main(String[] args) throws Exception {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() ->{
            for(char c : aI){
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() ->{
            for(char c : aC){
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        },"t2");

        t1.start();
        t2.start();
    }
}

package com.wicket.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C...26Z
 */
public class T_AtomicInteger {
    static AtomicInteger  threadNo = new AtomicInteger(1);

    public static void main(String[] args) throws Exception {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() ->{
            for(char c : aI){
                while (threadNo.get() != 1){}
                System.out.println(c);
                threadNo.set(2);
            }
        }).start();


        new Thread(() ->{
            for(char c : aC){
                while (threadNo.get() != 2){}
                System.out.println(c);
                threadNo.set(1);
            }
        }).start();
    }
}

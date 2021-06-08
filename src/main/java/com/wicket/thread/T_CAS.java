package com.wicket.thread;

import java.util.concurrent.locks.LockSupport;

/**
 *  用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C...26Z
 */
public class T_CAS {
    enum ReadyToRun {T1 ,T2};
    static volatile ReadyToRun r = ReadyToRun.T1;  //为什么必须是volatile

    public static void main(String[] args) throws Exception {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() ->{
            for(char c : aI){
                while( r != ReadyToRun.T1){}
                System.out.println(c);
                r = ReadyToRun.T2;
            }
        }, "t1").start();

        new Thread(() ->{
            for(char c : aC){
                while( r != ReadyToRun.T2){}
                System.out.println(c);
                r = ReadyToRun.T1;
            }
        },"t2").start();
    }
}

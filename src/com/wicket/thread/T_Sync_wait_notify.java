package com.wicket.thread;
/**
 *  用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C...26Z
 */
public class T_Sync_wait_notify {

    public static void main(String[] args) throws Exception {
        final Object o = new Object();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() ->{
            synchronized (o){
                for (char c : aI){
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();  //让出锁
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                o.notify(); //必须，否则无法停止程序
            }
        },"t1").start();

        new Thread(() ->{
            synchronized (o){
                for (char c : aC){
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();  //让出锁
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                o.notify(); //必须，否则无法停止程序
            }
        },"t2").start();
    }
}

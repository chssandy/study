package com.wicket.thread;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SimpleThreadTest
 * @description TODO
 * @date 2021/4/28 12:11
 */
public class SimpleThreadTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());  //打印当前运行线程名称
        Thread thread1 = new HelloThread();
        Thread thread2 = new HelloThread();
        thread1.start();
        thread2.start();


    }

    private static class HelloThread extends Thread {
        public void run(){
            for(int i=0;i<10 ;i++){
                System.out.println("Hello world ! " + this.getName() + " is running...");
            }
        }
    }
}

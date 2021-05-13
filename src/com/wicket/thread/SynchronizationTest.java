package com.wicket.thread;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SynchronizeTest
 * @description TODO
 * @date 2021/5/7 9:01
 */
public class SynchronizationTest {
    static Shared sharedObject = new Shared();
    private static class DemoThread1 extends Thread{
        public void run(){
//            synchronized (sharedObject){
                sharedObject.sorting();
//            }
        }
    }

    static class DemoThread2 extends Thread{
        public void run(){
//            synchronized (sharedObject){
                sharedObject.printing();
//            }
        }
    }

    public static void main(String[] args) {
        new DemoThread1().run();
        new DemoThread2().run();
    }

}

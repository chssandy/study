package com.wicket.thread;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname WaitNotifyAllTest
 * @description TODO
 * @date 2021/5/7 9:23
 */
public class WaitNotifyAllTest {
    static Shared3 shared3Object = new Shared3();

    private static class DemoThread1 extends Thread{
        public void run(){
            shared3Object.sorting();
        }
    }

    static class DemoThread2 extends Thread{
        public void run(){
            shared3Object.printing();
        }
    }

    public static void main(String[] args) {
        final int NUM = 100;
        DemoThread1[] demoSorting = new DemoThread1[NUM];
        DemoThread2[] demoPrinting = new DemoThread2[NUM];
        for(int i=0; i<demoSorting.length; i++){
            demoSorting[i] = new DemoThread1();
            demoPrinting[i] = new DemoThread2();
            demoSorting[i].start();
            demoPrinting[i].start();
        }
    }
}

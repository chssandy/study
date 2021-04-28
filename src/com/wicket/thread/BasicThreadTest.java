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
public class BasicThreadTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());  //打印当前运行线程名称
        Thread thread1 = new Thread(new MessageOne());
        Thread thread2 = new Thread(new MessageTwo());
        thread1.setPriority(10);
        thread2.setPriority(1);
        thread1.start();
        thread2.start();


    }

    private static class Letter{
        public void display(String letters){
            System.out.print(letters + " ");
        }
    }

    private static class MessageOne extends Letter implements Runnable {
        public void run(){
            for(int i=0;i<5 ;i++){
                display("JAVA ");
                display("SE ");
            }
        }
    }

    private static class MessageTwo extends Letter implements Runnable {
        public void run(){
            for(int i=0;i<10 ;i++){
                display("编程 ");
                display("艺术 ");
            }
        }
    }
}

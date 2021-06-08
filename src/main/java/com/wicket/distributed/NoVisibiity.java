package com.wicket.distributed;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname NoVisibiity
 * @description TODO
 * @date 2020/9/30 12:02
 */
public class NoVisibiity {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while(!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
            number = 42;
            ready = true;


    }
}

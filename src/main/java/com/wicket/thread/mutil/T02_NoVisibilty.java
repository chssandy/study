package com.wicket.thread.mutil;

public class T02_NoVisibilty {
    private static boolean ready = false;
    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run(){
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ReaderThread();
        t.start();
        number = 42;
        t.join();
    }
}

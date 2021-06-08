package com.wicket.thread;

public class ThreadJoinApp {
    public static void main(String[] args) {
        Thread demo = new Estimate();
        demo.start();
        try{
            demo.join();    //阻塞主线程运行，直到demo运行完毕
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("PI = " + Estimate.PI);
    }

    private static class Estimate extends Thread{
        private static double PI = 0.0;
        private int sign = 1;
        public void run(){
            for(long i= 1 ;i<999999;i += 2){
                PI +=4.0 * (double)sign/i;
                sign = -sign;
            }
        }
    }
}

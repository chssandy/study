package com.wicket.thread.mutil;

import static java.lang.Thread.sleep;

public class T01_HelloVolatile {
    private static volatile boolean runing = true;

    private static void m(){
        System.out.println("m start");
        while(runing){

        }
        System.out.println("m end");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(T01_HelloVolatile::m,"t1").start();
        sleep(1000);
        runing = false;
    }
}

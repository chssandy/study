package com.wicket.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname AtomicTest
 * @description TODO
 * @date 2020/10/30 17:41
 */
public class AtomicTest {
    public static AtomicInteger race = new AtomicInteger();
    public static void increase(){
        race.incrementAndGet();
    }

    private static final int THREADS_COUNT =20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i=0;i<THREADS_COUNT;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000;i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() >1){
            Thread.yield();
            System.out.println(race);
        }
    }
}

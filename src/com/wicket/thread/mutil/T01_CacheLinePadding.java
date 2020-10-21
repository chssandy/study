package com.wicket.thread.mutil;

import sun.misc.Contended;

import java.util.concurrent.CountDownLatch;

public class T01_CacheLinePadding {
    public static long COUNT = 10_0000_0000L;

    private static class T{
        //如果像运行注解需要加参数 ： -XX:RestrictContended
        @Contended  //只有1.8起作用，保证x位于单独一行
//        private long p1,p2,p3,p4,p5,p6,p7,p8;
        public long x = 0L;
//        private long p9,p10,p11,p12,p13,p14,p15,p16;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(()->{
            for(long i =0; i<COUNT; i++) {
                arr[0].x = i;
            }
            latch.countDown();
        });

        Thread t2 = new Thread(()->{
            for(long i= 0; i<COUNT; i++) {
                arr[1].x = i;
            }
            latch.countDown();
        });

    }
}


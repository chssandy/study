package com.wicket.thread.synchronousQueue;

import java.util.concurrent.SynchronousQueue;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname BlockingQueueTest
 * @description TODO
 * @date 2021/5/7 10:56
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<Product> bQue = new SynchronousQueue<Product>();
        Producer3 producer1 = new Producer3(bQue);    //创建两个共享集合的生产者
        Producer3 producer2 = new Producer3(bQue);
        Producer3 producer3 = new Producer3(bQue);
        Producer3 producer4 = new Producer3(bQue);

        Consumer3 consumer1 = new Consumer3(bQue);    //创建两个共享集合的消费者
        Consumer3 consumer2 = new Consumer3(bQue);
        Consumer3 consumer3 = new Consumer3(bQue);    //创建两个共享集合的消费者
        Consumer3 consumer4 = new Consumer3(bQue);

        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        new Thread(producer4).start();

        new Thread(consumer1).start();
        new Thread(consumer2).start();
//        new Thread(consumer3).start();
//        new Thread(consumer4).start();
    }
}

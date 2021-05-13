package com.wicket.thread.synchronousQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Consumer3
 * @description TODO
 * @date 2021/5/7 10:52
 */
public class Consumer3 extends Thread{       //消费者线程
    private final BlockingQueue<Product> bQue;

    Consumer3(BlockingQueue<Product> que){
        bQue = que;
    }

    public void run(){
        try {
            consuming(bQue.take());    //调用有协调功能的take()方法提取元素
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    void consuming(Object product){
        System.out.println(product + " consumed by " + Thread.currentThread().getName());
    }
}

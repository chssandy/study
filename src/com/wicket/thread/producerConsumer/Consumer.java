package com.wicket.thread.producerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Consumer
 * @description TODO
 * @date 2021/5/7 10:52
 */
public class Consumer extends Thread{       //消费者线程
    private Shop shop;

    public Consumer(Shop shop){     //构造方法
        this.shop = shop;        //进入市场交易
    }

    public void run(){
        Product product;                //引用产品
        try {
            Thread.sleep((int)(Math.random() *  1000 + 300));   //观察购买产品需要一定的时间
            product = shop.consuming();     //购买产品
            System.out.println(product + " is consumed by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();   //如果遇到异常，则停止当前进程
        }
    }
}

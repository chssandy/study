package com.wicket.thread.synchronousQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Producer3
 * @description TODO
 * @date 2021/5/7 10:42
 */
public class Producer3 extends Thread{          //生产者线程
    private final BlockingQueue<Product> bQue;  //利用接口作为参数

    private static int productNumber;

    Producer3(BlockingQueue<Product> bQue) {
        this.bQue = bQue;
    }

    public void run(){
        try {
            Thread.sleep(1000);
            bQue.put(producing());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    Product producing(){    //生产产品
        productNumber++;
        Product product = new Product(productNumber);
        return product;
    }
}

package com.wicket.thread.producerConsumer;

import java.util.LinkedList;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Shop
 * @description TODO
 * @date 2021/5/7 13:51
 */
public class Shop {
    private volatile LinkedList<Product> productQue = new LinkedList<Product>();

    public synchronized void producing(Product product){   //线程协调方法
        while(productQue.size() > 5){     //产品超界
            try{
                wait(100);   //等待100ms再运行
                System.out.println("Product are overstocked. waiting consumer to buy ...");
                System.out.println("Producer " + Thread.currentThread().getName() + " is waiting...");
            }catch (InterruptedException e){
                System.out.println(e);
            }
            notifyAll();     //通知所有等待线程有机会进入
            productQue.addLast(product);    //增添产品数目
            System.out.println("Number of  products avaliable: " + productQue.size());

        }
    }

    public synchronized Product consuming(){    //线程协调方法
        while(productQue.size() == 0){    //如果没有产品
            try{
                wait();
                System.out.println("Number of products avaliable:"  + productQue.size());
                System.out.println("Consumer " + Thread.currentThread().getName() + "is waiting...");
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        return productQue.removeFirst();    //否则从产品队列消费产品
    }

    public synchronized int getSize(){
        return productQue.size();   //返回产品队列中产品数量
    }
}

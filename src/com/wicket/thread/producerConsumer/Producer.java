package com.wicket.thread.producerConsumer;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Producer
 * @description TODO
 * @date 2021/5/7 14:01
 */
public class Producer extends Thread{  //生产线程
    private static volatile int productNumber;   //多线程共享数据
    private Shop shop;
    public Producer(Shop shop){    //构造方法
        this.shop = shop;          //使用交易市场
    }

    public void run(){    //覆盖run方法
        try{
            productNumber++;     //增加产品编号
            Product product = new Product(productNumber);   //创建新产品
            Thread.sleep( (int)(Math.random()*1000 + 200));   //需要一定时间进行生产
            shop.producing(product);     //产品上市，进入商店
            System.out.println(product + " produced by " + this.getName());   //打印产品信息
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();    //如果有异常，则中断当前进程
        }
    }




}

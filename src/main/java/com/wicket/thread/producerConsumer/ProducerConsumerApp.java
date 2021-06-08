package com.wicket.thread.producerConsumer;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname ProducerConsumerApp
 * @description TODO
 * @date 2021/5/7 14:12
 */
public class ProducerConsumerApp {
    public static void main(String[] args) {
        final int SIZE_OF_PRODUCER = 150;
        final int SIZE_OF_CONSUMER = 150;

        Thread producer[]  = new Producer[SIZE_OF_PRODUCER];
        Thread consumer[] = new Consumer[SIZE_OF_CONSUMER];

        Shop shop = new Shop();   //创建交易市场对象
        for(int i=0;i<producer.length;i++){   //所有生产线程
            producer[i] = new Producer(shop);   //共享市场
            producer[i].start();   //可执行状态
        }

        for(int i =0;i<consumer.length; i++){
            consumer[i]  = new Consumer(shop);   //共享市场
            consumer[i].start();
        }
    }
}

package com.wicket.thread;

import com.wicket.stream.apiIteration.C;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname ProduceConsumerBasicApp
 * @description TODO
 * @date 2021/4/28 14:04
 */
public class ProduceConsumerBasicApp {
    public static void main(String[] args) {
        Thread[] producer = new Producer[4];
        Thread[] consumer = new Consumer[4];
        for(int i = 0;i<4;i++){
            producer[i] = new Producer();
            producer[i].start();
            System.out.println("producer thread name: " + producer[i].getName()+ " is creating...");

            consumer[i] = new Consumer();
            consumer[i].start();
            System.out.println("consumer thread name: " + consumer[i].getName()+ " is creating...");
        }
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    private static class Shop{
        private static int numOfProduct =0;
        public static void producing(){
            numOfProduct++;
            System.out.println("Number of products available:" + numOfProduct);
        }
        public static void consuming(){
            numOfProduct--;
            System.out.println("Number of products available:" + numOfProduct);
        }
    }

    private static class Producer extends Thread{
        public void run(){
            System.out.print(this.getName());
            System.out.println(" is producing...");
            Shop.producing();
        }
    }

    private static class Consumer extends Thread{
        public void run(){
            System.out.print(this.getName());
            System.out.println(" is consuming...");
            Shop.consuming();
        }
    }

}

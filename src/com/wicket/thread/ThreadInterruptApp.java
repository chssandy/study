package com.wicket.thread;

import java.util.Scanner;

public class ThreadInterruptApp {
    public static void main(String[] args) {
        Thread service = new Service();  //创建线程对象
        service.start();    //设置可执行状态
        Scanner sc = new Scanner(System.in);  //键盘输入扫描
        String choice = "";
        while(!choice.equals("stop")) {  //如果不是stop则继续运行st
            choice = sc.next();      //等待用户输入
        }
        service.interrupt();       //如果是stop则调用interrupt停止线程运行
    }

    static class Service extends Thread{   //线程service
        private int count =1;       //服务计数器置1
        public void run(){
            while (!isInterrupted()){
                System.out.println(this.getName()+ " providing service " + count++);   //打印服务信息
                try {
                    Thread.sleep(2500);   //休息2.5s
                } catch (InterruptedException e) {
                    break;   //如果中断，处理这个异常并调用break停止
                }
            }
            System.out.println("Thread service is interrupt by user ...");  //打印停止运行信息
        }
    }
}

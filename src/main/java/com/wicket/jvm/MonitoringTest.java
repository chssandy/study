package com.wicket.jvm;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MonitoringTest
 * @description TODO
 * @date 2020/10/13 11:51
 */
public class MonitoringTest {
    /**
     *线程死锁等待演示
     */
    static class SynAddRunalbe implements Runnable{
        int a,b;
        public SynAddRunalbe(int a,int b){
            this.a=a;
            this.b=b;
        }

        @Override
        public void run(){
            synchronized(Integer.valueOf(a)){
                synchronized(Integer.valueOf(b)){
                    System.out.println(a+b);
                }
            }
        }
    }
    public static void main(String[] args){
        for(int i=0; i<100; i++){
            new Thread(new SynAddRunalbe(1,2)).start();
            new Thread(new SynAddRunalbe(2,1)).start();
        }
    }
}

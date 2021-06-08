package com.wicket.thread.threaLocal;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname UseThreadLocal
 * @description 演示threadLocal的使用
 * @date 2020/11/17 10:29
 */
public class UseThreadLocal {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
//    static MyThreadLocal<String> threadLocal = new MyThreadLocal<>();
    /**
     * 运行5个线程，每个线程持有自己独有的编号
     */
    public void StartThreadArray(){
        Thread[] runs = new Thread[5];
        for(int i=0; i<runs.length; i++){
            new TestThread(i).start();
        }
    }

    /**
     * 打印赋予的id值，应该包含0,1,2,3,4
     */
    public static class TestThread extends Thread{
        int id;
        public TestThread(int id){
            this.id = id;
        }

        public void run(){
            String threadName = Thread.currentThread().getName();
            threadLocal.set("线程"+id);
            if(id ==2 ) threadLocal2.set("线程2:"+id);
            System.out.println(threadName+threadLocal.get());
            System.out.println(threadName+threadLocal2.get());
        }
    }

    public static void main(String[] args) {
        UseThreadLocal test = new UseThreadLocal();
        test.StartThreadArray();
    }
}

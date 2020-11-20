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
public class NoThreadLocal {

    static int count;

    /**
     * 运行5个线程，每个线程持有自己独有的编号
     */
    public void StartThreadArray(){
        Thread[] runs = new Thread[5];
        //将i复制给线程
        for(int i=0; i<runs.length; i++){
            new Thread(new TestTask(i)).start();
        }
    }

    /**
     * 打印赋予的id值，应该包含0,1,2,3,4
     */
    public static class TestTask implements Runnable {
        int id;

        public TestTask(int id){
            this.id = id;
        }

        public void run(){
            count = id;
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+"编号为"+count);

        }
    }

    public static void main(String[] args) {
        NoThreadLocal test = new NoThreadLocal();
        test.StartThreadArray();
    }
}

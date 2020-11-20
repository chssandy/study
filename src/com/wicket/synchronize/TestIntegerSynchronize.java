package com.wicket.synchronize;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname TestIntegerSynchronize
 * @description TODO
 * @date 2020/11/18 9:57
 */
public class TestIntegerSynchronize {

    private static class Worker implements Runnable{

        private static Integer i;
        public Worker(Integer i){this.i =i;}
        @Override
        public void run() {
            synchronized (i){
                Thread thread = Thread.currentThread();
                i++;   //synchronized 锁不住i，因为i++实际上会 new Integer.valueOf(i)一个新对象，锁不住
                System.out.println(thread.getName()+"----------"+i+"-@"+System.identityHashCode(i));
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker(1);
        for (int i=0;i<5;i++){
            new Thread(worker).start();
        }
    }
}

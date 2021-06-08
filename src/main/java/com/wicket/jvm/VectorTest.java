package com.wicket.jvm;

import java.util.Vector;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname VectorTest
 * @description TODO
 * @date 2020/10/30 17:12
 */
public class VectorTest {
    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while (true){
            for(int i=0;i<vector.size();i++){
                vector.add(i);
            }
            Thread removeThread =new Thread(new Runnable(){
                @Override
                public void run(){
                    for(int i=0;i<vector.size();i++){
                        vector.remove(i);
                    }
                }
            });
            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<vector.size();i++){
                        System.out.println(vector.get(i));
                    }
                }
            });
            removeThread.start();
            printThread.start();
            //不要同时产生过多的线程，否则会导致操作系统假死
            while(Thread.activeCount()>40);
        }
    }
}

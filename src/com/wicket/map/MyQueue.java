package com.wicket.map;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MyQueue
 * @description TODO
 * @date 2021/4/27 16:51
 */
public class MyQueue {
    public static void main(String[] args) {
        GenericQueue<String> myQue = new GenericQueue<String>();
        myQue.inQue("One");
        myQue.inQue("Two");
        myQue.inQue("Three");

        int myQueSize = myQue.size();
        System.out.println(myQue);
        while (myQue.size() > 0){
            System.out.println(myQue.deQue());
        }
    }
}

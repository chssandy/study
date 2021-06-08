package com.wicket.map;

import java.util.LinkedList;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname GenericQueue
 * @description TODO
 * @date 2021/4/27 16:52
 */
public class GenericQueue<E> {
    private LinkedList<E> que = new LinkedList<E>();

    public void inQue(E item){
        que.addLast(item);
    }

    public E deQue(){
        return que.removeFirst();
    }

    public int size(){
        return que.size();
    }

    public boolean empty(){
        return que.isEmpty();
    }

    public String toString(){
        return que.toString();
    }
}

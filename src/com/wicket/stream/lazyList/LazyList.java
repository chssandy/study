package com.wicket.stream.lazyList;

import java.util.function.Supplier;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname LazyList
 * @description TODO
 * @date 2020/9/25 17:08
 */
public class LazyList<T> implements MyList<T> {
    final T head;
    final Supplier<MyList<T>> tail;
    public LazyList(T head ,Supplier<MyList<T>> tail){
        this.head = head;
        this.tail = tail;
    }

    public T head(){
        return head;
    }

    public MyList<T> tail(){
        return tail.get();
    }

    public boolean isEmpty(){
        return false;
    }
}

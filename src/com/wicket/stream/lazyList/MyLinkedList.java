package com.wicket.stream.lazyList;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MyLinkedList
 * @description TODO
 * @date 2020/9/25 17:04
 */
public class MyLinkedList<T> implements MyList {
    private final T head;
    private final MyList<T> tail;

    public MyLinkedList(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public Object head() {
        return head;
    }

    @Override
    public MyList tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}

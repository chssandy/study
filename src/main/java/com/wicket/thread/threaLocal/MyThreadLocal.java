package com.wicket.thread.threaLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MyThreadLocal
 * @description 实现自己的ThreadLocal
 * @date 2020/11/17 13:09
 */
public class MyThreadLocal<T> {
    /**
     * 存放变量副本的map容器，以Thread为键，变量副本为value
     * 这种实现方式性能低
     */
    private Map<Thread,T> threadMap = new HashMap<>();


    public synchronized T get() {
        return threadMap.get(Thread.currentThread());
    }

    public synchronized void set(T t) {
        threadMap.put(Thread.currentThread(),t);
    }
}

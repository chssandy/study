package com.wicket.stream.lazyList;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Empty
 * @description TODO
 * @date 2020/9/25 17:05
 */
public class Empty<T> implements MyList<T> {

    public T head(){
        throw new UnsupportedOperationException();
    }

    public MyList<T> tail(){
        throw new UnsupportedOperationException();
    }
}

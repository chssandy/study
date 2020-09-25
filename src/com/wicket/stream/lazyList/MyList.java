package com.wicket.stream.lazyList;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MyList
 * @description TODO
 * @date 2020/9/25 17:02
 */
public interface MyList<T> {
    T head();
    MyList<T> tail();

    default boolean isEmpty(){
        return  false;
    }
}

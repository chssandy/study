package com.wicket.stream.apiIteration;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname A
 * @description TODO
 * @date 2020/9/24 10:47
 */
public interface A {
    default void hello(){
        System.out.println("Hello from A");
    }
    default Number getNumber(){
        return 10;
    }
}

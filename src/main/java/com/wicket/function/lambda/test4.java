package com.wicket.function.lambda;

import java.util.function.IntConsumer;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname test4
 * @description TODO
 * @date 2023/3/20 21:05
 */
public class test4 {

    public static void main(String[] args) {
        foreachArr(value -> System.out.println(value));
    }

    public static void foreachArr(IntConsumer consumer){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for(int i : arr){
            consumer.accept(i);
        }
    }

}

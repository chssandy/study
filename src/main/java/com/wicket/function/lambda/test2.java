package com.wicket.function.lambda;

import java.util.function.IntPredicate;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname test2
 * @description TODO
 * @date 2023/3/20 20:47
 */
public class test2 {
    public static void main(String[] args) {
        System.out.println(11);
        printNum(value -> value%2 == 0);
    }

    public static void printNum(IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        for(int i : arr){
            if(predicate.test(i )){
                System.out.println(i);
            }
        }
    }
}

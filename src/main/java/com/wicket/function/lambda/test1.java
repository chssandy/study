package com.wicket.function.lambda;

import java.util.function.IntBinaryOperator;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname test1
 * @description TODO
 * @date 2023/3/20 20:25
 */
public class test1 {

    public static void main(String[] args) {
        int result = calculateNum((left, right) -> left * right);
        System.out.println(result);
    }
     public static int calculateNum(IntBinaryOperator operator){
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a,b);
     }
}

package com.wicket.function.lambda;

import java.util.function.Function;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname test3
 * @description TODO
 * @date 2023/3/20 21:00
 */
public class test3 {

    public static void main(String[] args) {
        int i = typeConver(s -> Integer.valueOf(s));
        System.out.println(i);
        String str = typeConver(s -> "CHS"+s);
        System.out.println(str);
    }

    public static <R> R typeConver(Function<String,R> function){
        String str = "12345";
        R result = function.apply(str);
        return result;
    }
}

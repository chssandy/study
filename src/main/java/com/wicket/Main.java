package com.wicket;


import java.lang.reflect.Field;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Main
 * @description TODO
 * @date 2020/8/26 9:48
 */
public class Main {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 3;
        System.out.println("befor swap: a="+a+",b="+b);
        swap(a,b);
        System.out.println("after swap: a="+a+",b="+b);
    }

    private static void swap(Integer num1,Integer num2){

        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int tmp = num1.intValue();

            field.set(num1,num2);
            field.set(num2,new Integer(tmp));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

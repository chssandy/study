package com.wicket.stream;

import java.util.Comparator;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MeaningOfThis
 * @description TODO
 * @date 2020/9/7 16:50
 */
public class MeaningOfThis {
    public final int value = 4;
    public void doIt(){
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
//        MeaningOfThis m = new MeaningOfThis();
//        m.doIt();
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight(),o2.getWeight());
            }
        };
        Comparator<Apple> byWeight1 = (Apple a1,Apple a2) -> Integer.compare(a1.getWeight(),a2.getWeight());
        System.out.println(byWeight);
        System.out.println(byWeight1);
    }



}

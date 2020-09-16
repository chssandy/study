package com.wicket.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Gougu
 * @description TODO
 * @date 2020/9/15 15:56
 */
public class Gougu {
    public static void main(String[] args) {
//        int[] a = {3,4,5};

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1,100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a,100)
                        .filter(b -> Math.sqrt(a*a + b*b) % 1 ==0)
                        .mapToObj(b ->
                                new int[]{a,b,(int)Math.sqrt(a*a + b*b)})
                );

        pythagoreanTriples.limit(5)
                .forEach(t ->
                        System.out.println(t[0]+","+t[1]+","+t[2]));

        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1,100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a,100)
                        .mapToObj(b -> new double[]{a,b,Math.sqrt(a*a + b*b)})
                        .filter(t -> t[2] % 1 ==0));
        pythagoreanTriples2.limit(5)
                .forEach(t ->
                        System.out.println(t[0]+","+t[1]+","+t[2]));
    }
}

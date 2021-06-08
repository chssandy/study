package com.wicket.paralleStream;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname NumberSum
 * @description TODO
 * @date 2020/9/18 16:42
 */
public class NumberSum {

    //流迭代求和
    public static long sequentialSum(long n){
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .reduce(0L,Long::sum);
    }

    //传统求和
    public static long iterativeSum(long n){
        long result = 0;
        for(long i=1L;i <= n; i++){
            result +=i;
        }
        return result;
    }

    //顺序流转换为并行流求和
    public static long parallelSum(long n){
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    public static long rangedSum(long n){
        return LongStream.rangeClosed(1,n)
                .reduce(0L,Long::sum);
    }

    public static long parallelRangedSum(long n){
        return LongStream.rangeClosed(1,n)
                .parallel()
                .reduce(0L,Long::sum);
    }



    public static void main(String[] args) {

//        long start = System.nanoTime();
//        long sum = sequentialSum(1000000000);
//        System.out.println(sum);
//        System.out.println(System.nanoTime() - start);
//
//        long start1 = System.nanoTime();
//        long sum1 = iterativeSum(1000000000);
//        System.out.println(sum1);
//        System.out.println(System.nanoTime() - start1);

        long start2 = System.nanoTime();
        long sum2 = parallelSum( 1000000000);
        System.out.println(sum2);
        System.out.println(System.nanoTime() - start2);
    }
}

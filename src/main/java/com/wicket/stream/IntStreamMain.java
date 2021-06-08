package com.wicket.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname IntStream
 * @description TODO
 * @date 2020/9/17 16:42
 */
public class IntStreamMain {

    //判断 candidate 是否为质数
    public boolean isPrime(int candidate){
        return IntStream.range(2,candidate)
                .noneMatch(i -> candidate % i ==0);
    }

    //判断candidate是否为质数（优化版本，仅判断小于被测数平方根）
    public boolean isPrimeSqrt(int candidate){
        int candidateRoot = (int) Math.sqrt((double)candidate);
        return IntStream.rangeClosed(2,candidateRoot)
                .noneMatch(i ->candidate % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrime(int n){
        return IntStream.rangeClosed(2,n).boxed()
                .collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }
    public static void main(String[] args) {
        IntStreamMain intStreamMain = new IntStreamMain();
        System.out.println(intStreamMain.partitionPrime(100));
    }
}

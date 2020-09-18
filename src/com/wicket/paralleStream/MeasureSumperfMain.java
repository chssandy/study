package com.wicket.paralleStream;

import java.util.function.Function;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MeasureSumperfMain
 * @description TODO
 * @date 2020/9/18 17:34
 */
public class MeasureSumperfMain {

    public long measureSumPerf(Function<Long,Long> adder,long n){
        long fastest = Long.MAX_VALUE;
        for(int i = 0;i < 10; i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() -start) / 1_000_000;
            System.out.println("Result:" + sum);
            if(duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static void main(String[] args) {
        MeasureSumperfMain main = new MeasureSumperfMain();
//        System.out.println("Sequential sum done in:" + main.measureSumPerf(NumberSum::sequentialSum,10_000_000) + "s");
//        System.out.println("Iterative sum done in:" + main.measureSumPerf(NumberSum::iterativeSum,10_000_000) + "s");
//        System.out.println("Parallel sum done in:" + main.measureSumPerf(NumberSum::parallelSum,10_000_000) + "s");
        System.out.println("Ranged sum done in:" + main.measureSumPerf(NumberSum::rangedSum,10_000_000) + "s");
        System.out.println("Parallel ranged sum done in:" + main.measureSumPerf(NumberSum::parallelRangedSum,10_000_000) + "s");
    }
}

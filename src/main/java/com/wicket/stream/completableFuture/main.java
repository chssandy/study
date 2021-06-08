package com.wicket.stream.completableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname main
 * @description TODO
 * @date 2020/9/25 9:23
 */
public class main {
    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        //执行更多任务，比如查询其他商品

        //在计算商品价格的同时
        try{
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n" ,price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrivalTime =  ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrivalTime + " msecs");
    }
}

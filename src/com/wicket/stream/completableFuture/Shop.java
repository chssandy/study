package com.wicket.stream.completableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Shop
 * @description TODO
 * @date 2020/9/24 17:37
 */
public class Shop {

    public Shop(String bestShop) {

    }

    public double getPrice(String product){
        //待实现
        return calculatePrice(product);
//        return 0.0;
    }

    public double calculatePrice(String product){
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay(){
        try{
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
    }


    public Future<Double> getPriceAsync(String product){

        return CompletableFuture.supplyAsync(() -> calculatePrice(product));

//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread( () -> {
//            try {
//                double price = calculatePrice(product);
//                futurePrice.complete(price);
//            }catch (Exception ex){
//                futurePrice.completeExceptionally(ex);
//            }
//
//        }).start();
//        return futurePrice;

    }
}

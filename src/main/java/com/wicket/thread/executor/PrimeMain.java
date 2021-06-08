package com.wicket.thread.executor;

import java.math.BigInteger;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname PrimeMain
 * @description TODO
 * @date 2020/12/28 16:05
 */
public class PrimeMain {
    public static void main(String[] args) {
        PrimeMain primeMain = new PrimeMain();
        try {
            primeMain.aSecondOfPrimes();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    List<BigInteger> aSecondOfPrimes() throws InterruptedException{
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try{
            SECONDS.sleep(1);
        }finally {
            generator.cancel();
        }
        return generator.get();
    }
}

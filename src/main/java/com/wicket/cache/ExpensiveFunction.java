package com.wicket.cache;

import java.math.BigInteger;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname ExpensiveFunction
 * @description TODO
 * @date 2020/12/15 9:24
 */
public class ExpensiveFunction implements Computable<String, BigInteger>{
    public BigInteger compute(String arg){
        return new BigInteger(arg);
    }
}

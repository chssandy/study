package com.wicket.cache;


import net.jcip.annotations.GuardedBy;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Memoizerl
 * @description TODO
 * @date 2020/12/15 9:23
 */
public class Memoizer1 implements Computable<String, BigInteger> {

    @GuardedBy("this")
    private final Map<String, BigInteger> cache = new HashMap<String, BigInteger>();
    private final Computable<String, BigInteger> c;

    public Memoizer1(Computable<String, BigInteger> c){
        this.c = c;
    }

    public synchronized BigInteger compute(String arg) throws InterruptedException, ExecutionException {
        BigInteger result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}

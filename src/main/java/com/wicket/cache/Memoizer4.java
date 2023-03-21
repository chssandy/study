package com.wicket.cache;


import net.jcip.annotations.GuardedBy;

import java.math.BigInteger;
import java.util.concurrent.*;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Memoizerl
 * @description TODO
 * @date 2020/12/15 9:23
 */
public class Memoizer4 implements Computable<String, BigInteger> {

    @GuardedBy("this")
    private final ConcurrentMap<String, Future<BigInteger>> cache = new ConcurrentHashMap<String,Future<BigInteger>>();
    private final Computable<String, BigInteger> c;

    public Memoizer4(Computable<String, BigInteger> c){
        this.c = c;
    }

    public BigInteger compute(final String arg) throws InterruptedException, ExecutionException {
        while (true) {
            Future<BigInteger> f = cache.get(arg);
            if (f == null) {
                Callable<BigInteger> eval = new Callable<BigInteger>() {
                    @Override
                    public BigInteger call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<BigInteger> ft = new FutureTask<>(eval);
                cache.putIfAbsent(arg,ft);
                if(f ==null) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (ExecutionException e) {
                throw launderThrowable(e.getCause());
            }
        }
    }

    public static ExecutionException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException)
            throw (RuntimeException) t;
        else if (t instanceof Error)
            throw (Error) t;
        else throw new RuntimeException(t);
    }
}

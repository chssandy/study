package com.wicket.cache;

import java.util.concurrent.ExecutionException;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Compuutable
 * @description TODO
 * @date 2020/12/15 9:22
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException, ExecutionException;
}

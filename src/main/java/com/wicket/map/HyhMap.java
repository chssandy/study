package com.wicket.map;

public interface HyhMap<K,V> {

    /**
     * PUT接口
     * @param k
     * @param v
     */
    void put(K k,V v);

    /**
     * GET接口
     * @param k
     * @return
     */
    V get(K k);

    /**
     * Entry接口
     * @param <K>
     * @param <V>
     */
    interface Entry<K,V>{
        /**
         * 获取KEY值
         * @return
         */
        K getKey();

        /**
         * 获取Value值
         * @return
         */
        V getValue();
    }
}

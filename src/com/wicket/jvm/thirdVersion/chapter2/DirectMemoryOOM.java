package com.wicket.jvm.thirdVersion.chapter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 * 本机直接内存溢出
 *
 *
 * 由直接内存导致的内存溢出，一个明显的特征是在Heap Dump文件中不会看见有什么明显的异常
 * 情况，如果读者发现内存溢出之后产生的Dump文件很小，而程序中又直接或间接使用了
 * DirectMemory（典型的间接使用就是NIO），那就可以考虑重点检查一下直接内存方面的原因了
 * @author zzm
 */
public class DirectMemoryOOM {

    private static final int _1MB =1024 * 1024;

    public static void main(String[] args) {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);   //可修改field
        try {
            Unsafe unsafe = (Unsafe) unsafeField.get(null);
            while(true){
                unsafe.allocateMemory(_1MB);   //真正申请分配内存的方法是Unsafe::allocateMemory()。
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

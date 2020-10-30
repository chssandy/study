package com.wicket.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname GrandFatherTest
 * @description jdk1.7中有效，可以直接在son分派 grandfather的thinking方法；jdk1.8无效
 * @date 2020/10/23 9:39
 */
public class GrandFatherTest {
    class GrandFather{
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather{
        void thinking(){
            System.out.println("i am father");
        }
    }

    class Son extends Father{
        void thinking(){
            try{
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class,"thinking",mt,getClass());
                mh.invoke(this);
            }catch (Throwable e){

            }
        }
    }

    public static void main(String[] args) {
        (new GrandFatherTest().new Son()).thinking();
    }

}

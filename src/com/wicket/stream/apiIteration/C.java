package com.wicket.stream.apiIteration;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname C
 * @description TODO
 * @date 2020/9/24 10:47
 */
public class C  implements A,B {
    public static void main(String[] args) {
//        new C().hello();
        System.out.println(new C().getNumber());
    }

    @Override
    public Number getNumber() {
        return A.super.getNumber();
    }


//    @Override
//    public void hello() {
//        A.super.hello();
//    }
}

package com.wicket.stream.lazyList;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname main
 * @description TODO
 * @date 2020/9/25 17:06
 */
public class main {

    public static LazyList<Integer> from(int n){
        return new LazyList<Integer>(n, () -> from(n+1));
    }

    public static void main(String[] args) {
        MyList<Integer> l = new MyLinkedList<>(5, new MyLinkedList<>(10,new Empty<>()));
        LazyList<Integer> numbers = from(2);
        int two = numbers.head();
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();
        System.out.println(two +" "+three + " " + four);

    }
}

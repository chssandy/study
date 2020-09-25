package com.wicket.stream.optional;

import java.util.Optional;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Person
 * @description TODO
 * @date 2020/9/24 14:23
 */
public class Person {
    private Optional<Car> car;  //人可能有车，也可能没有车，因此将这个字段声明为Optional
    public Optional<Car> getCar(){
        return car;
    }
}

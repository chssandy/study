package com.wicket.stream.optional;

import java.util.Optional;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Car
 * @description TODO
 * @date 2020/9/24 14:24
 */
public class Car {
    private Optional<Insurance> insurance;  //车可能有保险，也可能没有保险
    public Optional<Insurance> getInsurance(){
        return insurance;
    }
}

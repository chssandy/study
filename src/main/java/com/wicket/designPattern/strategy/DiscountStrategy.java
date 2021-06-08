package com.wicket.designPattern.strategy;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname DiscountStrategy
 * @description TODO
 * @date 2020/8/26 14:06
 */
public interface DiscountStrategy {
    //定义一个用于计算打折价的方法
    double getDiscount(double originPrice);
}

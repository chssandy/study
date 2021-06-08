package com.wicket.designPattern.strategy;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname VipDiscount
 * @description TODO
 * @date 2020/8/26 14:07
 */
public class OldDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double originPrice) {
        System.out.println("使用旧书折扣。。。");
        return originPrice * 0.7;
    }
}

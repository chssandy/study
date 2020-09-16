package com.wicket.strategy;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname StrategyTest
 * @description TODO
 * @date 2020/8/26 14:12
 */
public class StrategyTest {
    public static void main(String[] args) {
        //客户端没有悬着打折策略类
        DiscountContext dc = new DiscountContext(null);
        double price1 = 79;

        System.out.println("79元的书默认打折价格：" + dc.getDiscountPrice(price1));

        dc.changeDiscount(new VipDiscount());
        System.out.println("79元的书VIP打折价格：" + dc.getDiscountPrice(price1));

    }
}

package com.wicket.designPattern.facade;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname PaymentImpl
 * @description TODO
 * @date 2020/8/26 15:06
 */
public class PaymentImpl implements Payment {
    @Override
    public String pay() {
        String food = "快餐";
        System.out.println("你已经向收银员支付了费用，您购买的食物是：" + food);
        return food;
    }
}

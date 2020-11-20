package com.wicket.designPattern.observer;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Main
 * @description TODO
 * @date 2020/8/26 17:02
 */
public class Main {
    public static void main(String[] args) {
        Product p = new Product("电视剧",176);

        NameObserver no = new NameObserver();
        PriceObserver po = new PriceObserver();

//        p.registObserver(no);
//        p.registObserver(po);
        p.addObserver(no);
        p.addObserver(po);

        p.setName("书桌");
        p.setPrice(345f);

    }
}



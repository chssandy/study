package com.wicket.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname NameObserver
 * @description TODO
 * @date 2020/8/26 16:59
 */
public class PriceObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if( arg instanceof Double ){

            System.out.println("价格观察者：" + o + "物品价格已经改变为：" + arg);
        }
    }
}

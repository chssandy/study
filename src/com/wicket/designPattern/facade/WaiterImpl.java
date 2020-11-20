package com.wicket.designPattern.facade;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname WaiterImpl
 * @description TODO
 * @date 2020/8/26 15:17
 */
public class WaiterImpl implements Waiter {
    @Override
    public void server(String food) {
        System.out.println("服务生已将：" + food + "端过来了，请慢用...");
    }
}

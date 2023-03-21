package com.wicket.designPattern.adapter.objectAdapter;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Client
 * @description TODO
 * @date 2022/6/26 21:17
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("===对象适配器模式");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}


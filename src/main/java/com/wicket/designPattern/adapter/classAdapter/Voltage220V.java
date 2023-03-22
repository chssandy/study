package com.wicket.designPattern.adapter.classAdapter;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Voltage220V
 * @description TODO
 * @date 2022/6/26 20:26
 */
public class Voltage220V {
    //输出220V电压
    public int output220V(){
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}

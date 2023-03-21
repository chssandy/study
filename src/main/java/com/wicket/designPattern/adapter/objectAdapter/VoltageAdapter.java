package com.wicket.designPattern.adapter.objectAdapter;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname VoltageAdapter
 * @description 适配器类
 * @date 2022/6/26 21:11
 */
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;
    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dstV = 0;
        if(null != voltage220V){
            int srcV = voltage220V.output220V();
            System.out.println("使用对象适配器，进行适配~~");
            dstV = srcV / 44; //转成5V
            System.out.println("适配完成~~");
        }
        return dstV ;
    }
}

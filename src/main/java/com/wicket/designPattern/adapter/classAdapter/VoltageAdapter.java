package com.wicket.designPattern.adapter.classAdapter;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname VoltageAdapter
 * @description TODO
 * @date 2022/6/26 21:11
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        //获取220v电压
        int srcV = output220V();
        int dstV = srcV / 44; //转成5V
        return dstV ;
    }
}

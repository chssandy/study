package com.wicket.designPattern.factory;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname PrinterFactory
 * @description TODO
 * @date 2020/8/26 10:39
 */
public class BetterPrinterFactory implements OutputFactory{

    @Override
    public Output getOutput() {
        return new BetterPrinter();
    }
}

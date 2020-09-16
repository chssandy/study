package com.wicket.factory;


/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname OutputFactory
 * @description TODO
 * @date 2020/8/26 10:37
 */
public class OutputFactoryFactory {

    public static OutputFactory getOutputFactory(String type){
        if(type.equalsIgnoreCase("better")){
            return new BetterPrinterFactory();
        }else{
            return new PrinterFactory();
        }
    }
}

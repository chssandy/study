package com.wicket.easyFactory;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname OutputFactory
 * @description TODO
 * @date 2020/8/26 10:07
 */
public class OutputFactory {
    public Output getOutput(){
        return new BetterPrinter();
    }
}

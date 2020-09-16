package com.wicket.command;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname ProcessArray
 * @description TODO
 * @date 2020/8/26 13:34
 */
public class ProcessArray {
    public void each(int[] target,Command cmd){
        cmd.process(target);
    }
}

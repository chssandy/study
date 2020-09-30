package com.wicket.distributed;

import net.jcip.annotations.NotThreadSafe;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname UnsafeSequence
 * @description TODO
 * @date 2020/9/29 11:57
 */

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /** 返回一个唯一的数值 **/
    public int getNext(){
        return value++;
    }
}

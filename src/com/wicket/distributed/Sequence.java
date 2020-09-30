package com.wicket.distributed;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Sequence
 * @description TODO
 * @date 2020/9/29 12:04
 */
@ThreadSafe
public class Sequence {
    @GuardedBy("this") private int Value;
    public synchronized  int getNext(){
        return Value++;
    }
}

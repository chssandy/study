package com.wicket.designPattern.monitor;

import net.jcip.annotations.NotThreadSafe;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname MutablePoint
 * @description TODO
 * @date 2020/11/20 13:29
 */
@NotThreadSafe
public class MutablePoint {
    public int x,y;
    public MutablePoint(){
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p){
        this.x = p.x;
        this.y = p.y;
    }
}

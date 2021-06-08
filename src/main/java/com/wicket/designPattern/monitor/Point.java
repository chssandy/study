package com.wicket.designPattern.monitor;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Point
 * @description TODO
 * @date 2020/11/20 14:18
 */

import net.jcip.annotations.Immutable;

@Immutable
public class Point {
    public final int x,y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

}

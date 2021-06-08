package com.wicket.designPattern.monitor;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SafePoint
 * @description TODO
 * @date 2020/11/20 15:07
 */
@ThreadSafe
public class SafePoint {
    @GuardedBy("this") private int x,y;

    private SafePoint(int[] a){
        this(a[0],a[1]);
    }
    public SafePoint(SafePoint p){
        this(p.get());
    }

    public SafePoint(int x,int y){
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get(){
        return new int[]{x,y};
    }

    public synchronized void set(int x,int y){
        this.x = x;
        this.y = y;
    }
}

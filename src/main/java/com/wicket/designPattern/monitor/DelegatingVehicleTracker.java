package com.wicket.designPattern.monitor;

import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname DelegatingVehicleTracker
 * @description TODO
 * @date 2020/11/20 14:19
 */
@ThreadSafe
public class DelegatingVehicleTracker {
    private final ConcurrentMap<String,Point> locations;
    private final Map<String,Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String,Point> points){
        locations = new ConcurrentHashMap<String,Point>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String,Point> getLocations(){
//        return unmodifiableMap;

        return Collections.unmodifiableMap(new HashMap<String,Point>(locations));   //返回locations的静态拷贝而非实时拷贝
    }

    public Point getLocation(String id){
        return locations.get(id);
    }

    public void setLocation(String id,int x,int y){
        if(locations.replace(id,new Point(x,y)) == null){
            throw new IllegalArgumentException("invalid vehicle name: "+ id);
        }
    }
}

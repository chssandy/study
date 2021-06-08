package com.wicket.designPattern.monitor;

import net.jcip.annotations.ThreadSafe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname PublishingVehicleTracker
 * @description TODO
 * @date 2020/11/20 15:11
 */
@ThreadSafe
public class PublishingVehicleTracker {
    private final Map<String,SafePoint> locations;
    private final Map<String,SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String,SafePoint> locations){
        this.locations = new ConcurrentHashMap<String,SafePoint>(locations);
        this.unmodifiableMap = new ConcurrentHashMap<String,SafePoint>(this.locations);
    }

    public Map<String,SafePoint> getLocations(){
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id){
        return locations.get(id);
    }

    public void setLocation(String id,int x,int y){
        if(!locations.containsKey(id))
            throw new IllegalArgumentException("invalid vehicle name" + id);
        locations.get(id).set(x,y);
    }
}

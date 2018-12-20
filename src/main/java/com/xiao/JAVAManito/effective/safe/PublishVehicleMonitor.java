package com.xiao.JAVAManito.effective.safe;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by unclexiao on 19/05/2018.
 */
public class PublishVehicleMonitor {

    private final Map<String,SafePoint> locations;

    private final Map<String,SafePoint> unmodifiedLcocations;

    public PublishVehicleMonitor(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiedLcocations = Collections.unmodifiableMap(this.locations);
    }

    public Map<String,SafePoint> getLocations(){
        return this.unmodifiedLcocations;
    }

    public SafePoint getLocation(String id){
        return this.unmodifiedLcocations.get(id);
    }

    public void setLocation(String id,int x,int y){

        if(!this.unmodifiedLcocations.containsKey(id)){
            throw new IllegalArgumentException("无效的参数:"+id);
        }
        //由于 SafePoint可变，避免了不必要的对象创建
        this.locations.get(id).set(x,y);
    }

}

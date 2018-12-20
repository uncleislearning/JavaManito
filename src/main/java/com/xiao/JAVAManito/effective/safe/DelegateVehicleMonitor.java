package com.xiao.JAVAManito.effective.safe;


import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by unclexiao on 17/05/2018.
 *
 *
 * better way：DelegateVehicleMonitor线程安全委托给了 unmodifiedLocations对象
 */
public class DelegateVehicleMonitor {

    private final Map<String,Point> locations;

    //不可修改、线程安全的对象
    private final Map<String,Point> unmodifiedLocations;

    public DelegateVehicleMonitor(Map<String, Point> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiedLocations = Collections.unmodifiableMap(this.locations);
    }

    public Map<String,Point> getLocations(){
        //直接发布 依靠它的不可修改性、线程安全性 足够达到多线程环境的同步
        return this.unmodifiedLocations;
    }


    public Point getLocation(String id){
        //直接将Point对象发布，依靠它的不可变性
        return this.unmodifiedLocations.get(id);
    }

    //直接依靠 location的线程安全性进行修改操作，而且此时的修改能够被反映到快照中去
    public void setLocation(String id,int x,int y){
        if(id == null || locations.replace(id,new Point(x,y))==null ){
            throw new IllegalArgumentException("无效的 vehicle id:"+id);
        }

    }


}

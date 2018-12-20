package com.xiao.JAVAManito.effective.safe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by unclexiao on 17/05/2018.
 * <p>
 * <p>
 * 这是一个全局的车辆监控类，需要考虑一些同步策略来确保状态变量的安全
 *
 *
 * 对一份资源进行维护
 *
 *
 * VehicleMonitor的线程安全性 由 这里的同步策略来维护：
 *
 * 1. 将MutablePoint放到一个不可变的容器中进行管理
 * 2. 始终通过复制对象的方式来发布对象，使得原始的对象未曾离开它的作用域
 * 3. 对所有操作容器的方法进行加锁（线程安全性）
 *
 *
 * 有些缺点：当map中维护的MutablePoint数据量较大时，效率会比较低、同时可能会导致线程A拿到的是更新之前的数据而看不到更新之后的最新数据
 */
public class VehicleMonitor {

    //不可变，但非线程安全，实现线程安全性，下面的方法都进行了加锁
    //另外 由于保存的数据对象时可变的，所以采用的是复制的方式将对象发布出去
    private final Map<String, MutablePoint> locations;

    public  VehicleMonitor( Map<String, MutablePoint> locations) {
        this.locations = Collections.unmodifiableMap(locations);
    }

    //获取所有车辆的位置信息
    public synchronized Map<String, MutablePoint> getLocations() {
        //复制一份，而不将对象发布出去  发布的是一份快照
        return deepCopy(locations);
    }

    //获取指定车辆的位置信息
    public synchronized MutablePoint getLocation(String id) {
        return id == null ? null : new MutablePoint(this.locations.get(id));
    }


    //更新指定车辆的位置信息
    public synchronized void setLocation(String id, int x, int y) {
        if (id == null) {
            return;
        }

        MutablePoint point = this.locations.get(id);
        point.setX(x);
        point.setY(y);
    }

    //深拷贝
    private Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations) {
        Map<String, MutablePoint> copy = new HashMap<>();

        for (Map.Entry<String, MutablePoint> entry : locations.entrySet()) {
            copy.put(entry.getKey(), new MutablePoint(entry.getValue()));
        }
        return Collections.unmodifiableMap(copy);
    }


}

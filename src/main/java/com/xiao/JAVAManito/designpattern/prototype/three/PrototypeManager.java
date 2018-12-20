package com.xiao.JAVAManito.designpattern.prototype.three;

import java.util.Hashtable;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class PrototypeManager {

    private Hashtable<String,Car> hashtable = new Hashtable();

    public PrototypeManager() {
        hashtable.put("truck",new Truck());
        hashtable.put("bus",new Bus());
    }
    public Car getCar(String key){
        //这里返回的是对象的克隆
        return hashtable.get(key).clone();
    }
    private static final PrototypeManager pm = new PrototypeManager();

    public static PrototypeManager getInstance(){
        return pm;
    }


}

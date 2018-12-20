package com.xiao.JAVAManito.designpattern.prototype.three;


/**
 * Created by unclexiao on 2017/12/18.
 */
public class Truck implements Car {
    @Override
    public void drive() {
        System.out.println("卡车");
    }

    @Override
    public Truck clone(){
        Truck t = null;
        try {
            t = (Truck) super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("not support cloneable");
        }
        return t;
    }
}

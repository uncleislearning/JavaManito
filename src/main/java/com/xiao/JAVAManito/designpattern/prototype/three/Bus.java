package com.xiao.JAVAManito.designpattern.prototype.three;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class Bus implements Car {
    @Override
    public void drive() {
        System.out.println("公交车");
    }

    @Override
    public Bus clone(){
        Bus b = null;
        try{
            b = (Bus) super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("not support cloneable");
        }
        return b;
    }
}

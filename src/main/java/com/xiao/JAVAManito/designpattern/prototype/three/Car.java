package com.xiao.JAVAManito.designpattern.prototype.three;

/**
 * Created by unclexiao on 2017/12/18.
 *
 * 原型
 */
public interface Car extends Cloneable{
    void drive();
    Car clone();
}

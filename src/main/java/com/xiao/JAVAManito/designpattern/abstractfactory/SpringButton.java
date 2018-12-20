package com.xiao.JAVAManito.designpattern.abstractfactory;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("展示spring风格的button");
    }
}

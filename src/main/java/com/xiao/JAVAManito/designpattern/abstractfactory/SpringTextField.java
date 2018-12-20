package com.xiao.JAVAManito.designpattern.abstractfactory;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("正在展示spring风格的TextField");
    }
}

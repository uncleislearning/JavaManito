package com.xiao.JAVAManito.designpattern.simplefactory;

/**
 * Created by unclexiao on 2017/12/16.
 */
public class SquareShape implements Shape{

    @Override
    public void draw() {
        System.out.println("正在画矩形");
    }

    @Override
    public void erase() {
        System.out.println("正在擦除矩形");
    }
}

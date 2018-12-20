package com.xiao.JAVAManito.designpattern.decorator;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class BlackBorderDecorator extends Decorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }

    public void display(){
        super.display();
        setBlackBorder();
    }
    public void setBlackBorder(){
        System.out.println("为构建增加黑色边框");
    }
}

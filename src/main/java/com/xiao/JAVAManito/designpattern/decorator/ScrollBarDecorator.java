package com.xiao.JAVAManito.designpattern.decorator;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class ScrollBarDecorator extends Decorator {
    public ScrollBarDecorator(Component component) {
        super(component);
    }
    public void display(){

        super.display();
        setScrollBar();
    }

    public void setScrollBar(){
        System.out.println("为构建增加滚动条");
    }
}

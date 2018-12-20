package com.xiao.JAVAManito.designpattern.decorator.temple;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class ContreteDecorator extends Decorator {

    //注入Component
    public ContreteDecorator(Component component) {
        super(component);
    }

    public void operation(){
        //调用原来的operation方法
        super.operation();

        //在基础之上增加新的功能
        newBehavior();
    }
    public void newBehavior(){
        System.out.println("新的功能1");
    }

}

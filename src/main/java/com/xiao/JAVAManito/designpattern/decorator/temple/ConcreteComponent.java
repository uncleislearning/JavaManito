package com.xiao.JAVAManito.designpattern.decorator.temple;

/**
 * Created by unclexiao on 2017/12/23.
 */
public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("我是具体的一个组件");
    }
}

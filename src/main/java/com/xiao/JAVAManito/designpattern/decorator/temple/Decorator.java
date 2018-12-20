package com.xiao.JAVAManito.designpattern.decorator.temple;

/**
 * Created by unclexiao on 2017/12/23.
 */
public abstract class Decorator implements Component{

    private Component component;


    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

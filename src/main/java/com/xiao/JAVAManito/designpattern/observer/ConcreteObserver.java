package com.xiao.JAVAManito.designpattern.observer;

/**
 * Created by unclexiao on 28/09/2018.
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update() {
        System.out.println("Observe 收到！");
    }
}

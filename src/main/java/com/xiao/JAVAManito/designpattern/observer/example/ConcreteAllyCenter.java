package com.xiao.JAVAManito.designpattern.observer.example;

import java.util.List;

/**
 * Created by unclexiao on 28/09/2018.
 */
public class ConcreteAllyCenter extends AllyCenter {

    private static final String DEFAULT_NAME="";

    public ConcreteAllyCenter() {
    }

    public ConcreteAllyCenter(String name) {
        super(name);
    }

    public ConcreteAllyCenter(String name, List<Observer> observers) {
        super(name, observers);
    }

    public ConcreteAllyCenter(List<Observer> observers) {
        super(DEFAULT_NAME,observers);
    }
    @Override
    public void notifyObservers(Observer observer) {
        for(Observer o : observers){
            //通知其他盟友，请求盟友的帮助
            if(!o.getName().equalsIgnoreCase(observer.getName())){
                o.help();
            }
        }
    }
}

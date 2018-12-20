package com.xiao.JAVAManito.designpattern.observer.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unclexiao on 28/09/2018.
 */
public abstract class AllyCenter {
    protected String name;
    protected List<Observer> observers = new ArrayList<>();

    public AllyCenter() {
    }

    public AllyCenter(String name) {
        this.name = name;
    }

    public AllyCenter(String name, List<Observer> observers) {
        this.name = name;
        this.observers = observers;
    }

    public void addObserver(Observer observer){
        System.out.println(observer.getName()+"加入"+this.name+"阵营");
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        System.out.println(observer.getName()+"退出"+this.name+"阵营");
        observers.remove(observer.getName());
    }

    public abstract void notifyObservers(Observer observer);
}

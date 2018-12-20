package com.xiao.JAVAManito.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unclexiao on 28/09/2018.
 */
public abstract class ObserveSubject {
    List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void removeObserver(Observer observer){
     observerList.remove(observer);
    }
    public abstract void notifyAllObserver();
}

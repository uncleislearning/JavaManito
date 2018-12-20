package com.xiao.JAVAManito.designpattern.observer;

/**
 * Created by unclexiao on 28/09/2018.
 */
public class ConcreteObserveSubject extends ObserveSubject {
    @Override
    public void notifyAllObserver() {
        for (Observer o:observerList){
            o.update();
        }
    }
}

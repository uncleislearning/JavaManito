package com.xiao.JAVAManito.designpattern.observer.example2;

import java.util.Observable;

/**
 * Created by unclexiao on 28/09/2018.
 */
public class AllyCenter extends Observable {
    private String name;

    public AllyCenter(String name) {
        this.name = name;
    }

    public AllyCenter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //回调接口 一个动作，改变状态，并通知观察者门
    public void receiveAttacked(Player player){
        //改变状态
        setChanged();
        //通知观察者门
        notifyObservers(player.getName());
    }

}

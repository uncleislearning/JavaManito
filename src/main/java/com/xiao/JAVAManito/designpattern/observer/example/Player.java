package com.xiao.JAVAManito.designpattern.observer.example;

/**
 * Created by unclexiao on 28/09/2018.
 */
public class Player implements Observer {

    private String name;


    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void beAttacked(AllyCenter center) {
        System.out.println(this.name+"遭遇攻击！");
        center.notifyObservers(this);
    }

    @Override
    public void help() {
        System.out.println("坚持住！"+this.name+"正在前往支援!");
    }
}

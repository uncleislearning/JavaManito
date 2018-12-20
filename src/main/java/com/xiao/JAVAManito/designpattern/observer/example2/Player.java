package com.xiao.JAVAManito.designpattern.observer.example2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by unclexiao on 28/09/2018.
 */
public class Player implements Observer {

    private String name;


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void help() {
        System.out.println(this.name + "正在前往支援！");
    }


    public void join(AllyCenter center){
        System.out.println(this.getName()+"加入"+center.getName()+"阵营");
        center.addObserver(this);
    }



    //这里算是一个事件，将消息传递给观察目标（实质是引起观察目标的状态改变，从而触发通知）
    public void attacked(AllyCenter center) {
        System.out.println(this.getName() + "受到攻击");
        center.receiveAttacked(this);
    }


    //回调接口，由观察目标调用
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof AllyCenter) {
            if (arg instanceof String && !((String) arg).equalsIgnoreCase(this.getName())) {
                help();
            }
        }
    }
}

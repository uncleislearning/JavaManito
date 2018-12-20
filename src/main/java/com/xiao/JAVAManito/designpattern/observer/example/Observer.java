package com.xiao.JAVAManito.designpattern.observer.example;

/**
 * Created by unclexiao on 28/09/2018.
 */
public interface Observer {
    public void setName(String name);

    public String getName();

    //受到攻击 通知 通信中心
    public void beAttacked(AllyCenter center);

    //支持盟友的方法
    public void help();
}

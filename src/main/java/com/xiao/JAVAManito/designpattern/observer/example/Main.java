package com.xiao.JAVAManito.designpattern.observer.example;

/**
 * Created by unclexiao on 28/09/2018.
 */
public class Main {
    public static void main(String[] args) {

        AllyCenter allyCenter = new ConcreteAllyCenter("老虎阵营");

        Observer a = new Player("杨过");
        allyCenter.addObserver(a);


        Observer b = new Player("郭靖");
        allyCenter.addObserver(b);

        Observer c = new Player("欧阳锋");
        allyCenter.addObserver(c);



        b.beAttacked(allyCenter);
    }
}

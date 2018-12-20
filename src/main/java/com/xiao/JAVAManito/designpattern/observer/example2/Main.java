package com.xiao.JAVAManito.designpattern.observer.example2;



/**
 * Created by unclexiao on 28/09/2018.
 */
public class Main {
    public static void main(String[] args) {
        AllyCenter allyCenter = new AllyCenter("老虎");

        Player a = new Player("杨过");
        a.join(allyCenter);


        Player b = new Player("郭靖");
        b.join(allyCenter);

        Player c = new Player("欧阳锋");
        c.join(allyCenter);


        b.attacked(allyCenter);


        // Player.attacked ---> AllyCenter.receiveAttacked --->AllyCenter.notifyObservers--->Player.update

    }
}

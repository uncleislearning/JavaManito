package com.xiao.JAVAManito.designpattern.prototype.three;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class MainTest {
    public static void main(String[] args) {
        //不使用原型管理器
//        Truck t1,t2;
//        Bus b1,b2;
//        t1 = new Truck();
//        t2 = t1.clone();
//        t2.drive();
//
//
//        b1 = new Bus();
//        b2 = b1.clone();
//        b2.drive();

        //使用原型管理器
        PrototypeManager pm = PrototypeManager.getInstance();

        Truck t1,t2;
        t1 = (Truck) pm.getCar("truck");
        t2= (Truck) pm.getCar("truck");
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t1 == t2);

        Bus b1,b2;
        b1 = (Bus) pm.getCar("bus");
        b2 = (Bus) pm.getCar("bus");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1==b2);

    }
}

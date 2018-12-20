package com.xiao.JAVAManito.effective.classandinterface;

import java.util.Collections;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by unclexiao on 02/06/2018.
 */
public class GoodPoint {
    /**
     *  static final 如果使用public 可见性，则应该修改 primitive variable and immutable Object，bad Example：
     *  public static final String[] OBJECTS = {}
     */
    public static final int MAX_NUM = 12;
    private int x;
    private int y;
    //不安全，违背了初衷
    public static final String[] OBJECTS = {"a","b"};

    public GoodPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void main(String[] args) {
//        GoodPoint.OBJECTS[0] = "change";
//        System.out.println(GoodPoint.OBJECTS[0]);


        ConcurrentHashMap<String,Object> c  = new ConcurrentHashMap();

        // 如果不存在 则放入，否则 返回value

        String key = "a";
        synchronized (c) {
            if (!c.contains(key)) { //不要求要求
                c.put(key, new Object()); //要求要锁
            } else {
                c.get(key); //不要求要锁
            }
        }


    }

}

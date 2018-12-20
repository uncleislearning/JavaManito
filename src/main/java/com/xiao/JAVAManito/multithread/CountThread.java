package com.xiao.JAVAManito.multithread;

/**
 * Created by unclexiao on 2017/11/19.
 * <p>
 * 多线程技术实现的第一种方式：继承Thread类，重复run方法
 *
 * @author unclexiao
 */
public class CountThread extends Thread {

    private String name;

    private Number number;
    public CountThread(Number number){
        this.number = number;
    }
    public CountThread(String name,Number number) {
        this.name = name;
        this.number = number;
    }

    /**
     *  多线程同步问题解决方法一：synchronized + key
     *
     *  注意时static的，对象间共享
     */
    static Object key="key";

    @Override
    public void run() {
        for (int i=0;i<5;i++) {
            //加锁，使得多个线程（对象）在操作时，只有拿到key的对象才能进入
            synchronized (key) {
                number.subduction(1);
                System.out.println(this.name + "-----" + number.getNum());
            }
        }
    }
}

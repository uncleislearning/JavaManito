package com.xiao.JAVAManito.multithread;

/**
 * Created by unclexiao on 2017/11/19.
 */
public class MyRunnable implements Runnable {
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(i);
        }
    }
}

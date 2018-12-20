package com.xiao.JAVAManito.threadpool;

/**
 * Created by unclexiao on 2017/11/20.
 */
public class TestRunnable implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("我被执行了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

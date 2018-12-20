package com.xiao.JAVAManito.multithread.wait;

import sun.jvm.hotspot.runtime.Threads;

/**
 * Created by unclexiao on 30/01/2018.
 */
public class DemoTest {


    static class DemoNotify implements Runnable {

        private Object lock;

        public DemoNotify(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {

            synchronized (lock) {  //由于之前锁被占用，线程阻塞在这
                System.out.println("开始执行notify");

                lock.notify();//唤醒等待线程

                System.out.println("结束执行notify");//执行完，释放锁
            }


        }
    }


    static class TestWait implements Runnable {

        private Object lock;

        public TestWait(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("开始执行Thread Wait");

                try {
                    lock.wait();//释放锁

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("结束执行Thread Wait");

            }
        }
    }

    public static void main(String[] args) {
        Object o = new Object();
        new Thread(new TestWait(o)).start();
        new Thread(new DemoNotify(o)).start();

    }
}

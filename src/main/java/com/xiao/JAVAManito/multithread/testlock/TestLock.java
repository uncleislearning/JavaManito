package com.xiao.JAVAManito.multithread.testlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * Created by unclexiao on 19/03/2018.
 */
public class TestLock {


    public static class MyRunnable implements Runnable {

        private int count;
        private Lock lock = new ReentrantLock();

        @Override
        public void run() {

            for (int i = 0; i < 3; i++) {

                lock.lock();
                try {
                    count++;
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                }finally {
                    lock.unlock();
                }

            }

        }
    }



    public static class MyRunnable2 implements Runnable {

        private int count;
        private ReadWriteLock lock = new ReentrantReadWriteLock();

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                lock.writeLock().lock();
                try {
                    count++;
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                }finally {
                    lock.writeLock().unlock();
                }
            }

        }
    }



    public static void main(String[] args) {
        MyRunnable2 task = new MyRunnable2();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 3).forEach(i -> executorService.submit(task));
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}

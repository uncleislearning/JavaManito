package com.xiao.JAVAManito.threadpool;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by unclexiao on 2017/11/20.
 */
public class MainTest {
    public static void main(String[] args) {
        // Returns the number of processors available to the Java virtual machine.
        int cpuCoreCount = Runtime.getRuntime().availableProcessors();

        MyThreadFactory threadFactory = new MyThreadFactory();

        TestRunnable runnable = new TestRunnable();
        //
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(cpuCoreCount,threadFactory);

        ExecutorService cashedThreadPool = Executors.newCachedThreadPool(threadFactory);

        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(cpuCoreCount,threadFactory);

        ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor(threadFactory);

        fixedThreadPool.submit(runnable);
        cashedThreadPool.submit(runnable);
        newScheduledThreadPool.scheduleAtFixedRate(runnable,0,1, TimeUnit.SECONDS);
        singleThreadExecutor.scheduleWithFixedDelay(runnable,0,100,TimeUnit.MILLISECONDS);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fixedThreadPool.shutdown();
        cashedThreadPool.shutdown();
        newScheduledThreadPool.shutdown();
        singleThreadExecutor.shutdown();
    }
}

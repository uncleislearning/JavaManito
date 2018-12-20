package com.xiao.JAVAManito.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by unclexiao on 2017/11/20.
 */
public class MyThreadFactory implements ThreadFactory {
    private static AtomicInteger threadNumber = new AtomicInteger(1);
    public Thread newThread(Runnable r) {
        return new Thread("aThread-"+threadNumber.incrementAndGet());
    }
}

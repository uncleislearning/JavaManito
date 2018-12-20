package com.xiao.JAVAManito.multithread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by unclexiao on 18/06/2018.
 */
public class ExecutorManger {
    private final ExecutorService executorPool ;

    public ExecutorManger(int poolSize) {
        this.executorPool = Executors.newFixedThreadPool(poolSize);
    }


    public void executor(Runnable task){
        executorPool.execute(task);
    }

    public static void main(String[] args) {
        ExecutorManger executorManger = new ExecutorManger(10);
        BlockingQueue<Item > items = new ArrayBlockingQueue(100);
        executorManger.executor(new Producer(items));
        executorManger.executor(new Consumer(items));

        executorManger.executor(new Producer(items));
        executorManger.executor(new Consumer(items));

        executorManger.executor(new Producer(items));
        executorManger.executor(new Consumer(items));
    }
}

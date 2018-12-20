package com.xiao.JAVAManito.multithread.executor;

import java.util.concurrent.BlockingQueue;

/**
 * Created by unclexiao on 18/06/2018.
 */
public class Producer implements Runnable {

    private final BlockingQueue<Item> itemPool;

    public Producer(BlockingQueue<Item> itemPool) {
        this.itemPool = itemPool;
    }

    @Override
    public void run() {

       for(int i=1;i<=10;i++){
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            itemPool.offer(new Item());
        }
    }
}

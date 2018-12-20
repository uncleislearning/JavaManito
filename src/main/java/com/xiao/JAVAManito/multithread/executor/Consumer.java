package com.xiao.JAVAManito.multithread.executor;

import java.util.concurrent.BlockingQueue;

/**
 * Created by unclexiao on 18/06/2018.
 */
public class Consumer implements Runnable {
    private final BlockingQueue<Item> itemPool;

    public Consumer(BlockingQueue<Item> itemPool) {
        this.itemPool = itemPool;
    }

    @Override
    public void run() {
       while (true){
          Item item = itemPool.poll();
       }
    }
}

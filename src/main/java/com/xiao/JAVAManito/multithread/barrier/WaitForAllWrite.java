package com.xiao.JAVAManito.multithread.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by unclexiao on 14/06/2018.
 */
public class WaitForAllWrite {



    static class Writer implements Runnable{
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+":完成写入任务");
                //等待其他线程写入完成
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+":已经释放");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class AfterWriteTask implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+":所有线程都已经到达，执行任务");
        }
    }

    public static void main(String[] args) {
        int num = 4;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(num,new AfterWriteTask());
        for(int i=0;i<num;i++){
            new Thread(new Writer(cyclicBarrier)).start();
        }


    }
}

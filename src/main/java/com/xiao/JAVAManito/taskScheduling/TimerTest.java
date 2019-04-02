/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.taskScheduling;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author xiaomengning
 * @version $Id: TimerTest.java, v 0.1 2019年03月28日 16:07 xiaomengning Exp $
 */
public class TimerTest {

    private static class CountTask extends TimerTask {

        private AtomicInteger n;

        public CountTask(AtomicInteger n) {
            this.n = n;
        }

        /**
         * 定义任务需要完成的工作
         */
        @Override
        public void run() {
            if(n == null){
                throw new RuntimeException("illege param:"+this.getClass().getFields()[0]);
            }
            n.getAndIncrement();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date(System.currentTimeMillis()).toString()+"---n："+n);
        }
    }


    public static void main(String[] args) throws InterruptedException {


        //0.构造任务
        AtomicInteger n = new AtomicInteger(1);
        CountTask countTask1 = new CountTask(n);
        CountTask countTask2 = new CountTask(n);


        System.out.println(new Date());


        Timer timer = new Timer();


        //1.单次任务执行


        // 一秒以后，执行counttask1
        //timer.schedule(countTask1,1000L);
        timer.schedule(countTask1,new Date(System.currentTimeMillis()-3000L));


        //2. 周期性任务执行
        //

        // 一秒以后开始执行，并且每个固定时间间隔1秒再次执行，周期性被执行
      //  timer.schedule(countTask1,1000L,2000L);
        //timer.schedule(countTask1,new Date(System.currentTimeMillis()+1000L),1000L);
        // e> s   不执行  正常任务能够在固定时间间隔内完成的情况
        //e< s 立即执行   任务在固定时间间隔内完成不了，也只能等待，因为是单线程




    }




}
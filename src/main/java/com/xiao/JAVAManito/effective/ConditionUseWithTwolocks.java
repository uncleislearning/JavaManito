package com.xiao.JAVAManito.effective;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by unclexiao on 07/06/2018.
 *
 * 生产者 消费者 1：1
 * 需求：
 * 一、有一个线程取，如果缓冲区空，线程阻塞
 * 二、有一个线程放，如果缓冲区满，线程阻塞
 * 三、当有一个空闲空间时，唤醒一个put线程
 * 四、当有一个Item时，唤醒一个take线程
 *
 *
 * 这个 是LinkedBlockingQueue 线程同步的实现原型
 */
public class ConditionUseWithTwolocks {


    private final Lock putLock = new ReentrantLock();
    private final Lock takeLock = new ReentrantLock();

    private final Condition notFull = putLock.newCondition();
    private final Condition notEmpty = takeLock.newCondition();


    private static final Integer DEFALT_CAPABILITY = 100;

    //共享的Buffer
    private final Object[] buffer = new Object[DEFALT_CAPABILITY];

    private int size,tIndex,pIndex;
    private int length = this.buffer.length;


    public Object take() throws InterruptedException {
        Object item;

        try {
            // 1.获得锁
            this.takeLock.lock();

            //2.判断是否还有元素
            while (this.size == 0) {
                this.notEmpty.await();
            }
            //3.取元素
            item = this.buffer[this.tIndex++];
            // 循环使用
            if (this.tIndex == this.length) {
                this.tIndex = 0;
            }

            this.size--; //4.缓存中Item计数
        }finally {
            this.takeLock.unlock(); //6.释放锁
        }

        this.putLock.lock();
        this.notFull.signal(); // 5.唤醒一个put线程
        this.putLock.unlock();

        return item;
    }

    public void put(Object o) throws InterruptedException {
        try {
            //1.获取锁
            this.putLock.lock();

            //2.判断是否有空间
            while (this.size == this.length) {
                this.notFull.await();  //释放与该condition 相关的锁 ---> 唤醒一个take线程（如果此时一直没有take线程来取元素，则该put方法会一直阻塞）
            }

            //3.有空间
            this.buffer[this.pIndex++] = o;
            if (this.pIndex == this.length) {
                // 循环使用
                this.pIndex = 0;
            }
            this.size++;

        }finally {
            //确保锁释放
            this.putLock.unlock();
        }

        this.takeLock.lock();
        this.notEmpty.signal();
        this.takeLock.unlock();
    }




    static class TaskTake implements Runnable{

        private ConditionUseWithTwolocks conditionUse;

        public TaskTake(ConditionUseWithTwolocks conditionUse) {
            this.conditionUse = conditionUse;
        }

        @Override
        public void run() {
            int num=100;
            while ( num-- >0){
                try {
                    System.out.println(this.conditionUse.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class TaskPut implements Runnable{

        private ConditionUseWithTwolocks conditionUse;

        public TaskPut(ConditionUseWithTwolocks conditionUse) {
            this.conditionUse = conditionUse;
        }

        @Override
        public void run() {
            int num=100;
            while ( num-- >0){
                try {
                    conditionUse.put(""+num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ConditionUseWithTwolocks conditionUse = new ConditionUseWithTwolocks();

        TaskPut put = new TaskPut(conditionUse);
        TaskTake taskTake = new TaskTake(conditionUse);

        new Thread(put).start();
        new Thread(taskTake).start();

    }
}

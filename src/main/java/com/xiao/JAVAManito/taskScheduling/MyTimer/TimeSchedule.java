/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.taskScheduling.MyTimer;



/**
 * 任务调度类
 * @author xiaomengning
 * @version $Id: TimeSchedule.java, v 0.1 2019年03月28日 20:18 xiaomengning Exp $
 */
public class TimeSchedule {


    /**
     * 任务等待队列
     */
    private final XTaskQueue taskQueue = new XTaskQueue();

    /**
     * 任务执行线程
     */
    private final XTimerThread taskConsumeThread = new XTimerThread(taskQueue);


    private void init(){
        taskConsumeThread.start();
    }



    public TimeSchedule(){
        init();
    }


    /**
     * 调度方法
     */
    public void schedule(XTimerTask timerTask,ScheduleConfig config){
        if(timerTask == null || config == null){
            throw new RuntimeException("Illegal method params：null");
        }

        /**
         * 放到配置类中校验了
         */
        //validate(config);


        //为什么不能放在这里：task 是外部传进来的，你无法保证 此时此刻外部是否还有其他的线程正在操作task。但这里这个方法必须要保证 task的调度时间修改成用户希望的那样
        //mergeToTask(timerTask,config);
        synchronized (taskQueue){
            //获得操作队列的权力

            //检查一下标志位，是否可以接受任务的提交
            if(!taskConsumeThread.newTaskAccepted){
                throw new IllegalStateException("Timer has been cancelled！");
            }
            /**
             * 为什么要获取锁之后，再来判断任务的状态呢
             *
             * 因为用户期望的是使用这个方法，得到的效果是具有一致性的，比如用户传入一个origin 任务给schedule方法，在某一个时刻，有另一个线程修改了这个任务的状态，而如果在此时此刻，当前这个线程又执行下面任务状态检查的这段代码，结果一定会抛出异常
             * 这不是用户期望的效果，因为在用户的眼中，我分明传入了一个origin 状态的任务，为什么你要抛出 任务状态非法呢？
             *
             * 原因在于，当前线程没有试图去拿锁，就执行用任务的状态来进行判断，忽略了 当前可能已经有线程正在操作任务了
             *
             *
             *
             * 得出的结论是：操作任务任何可被共享的属性时，都要先去拿锁，无论你想对属性做什么操作（判断？修改？）都要先去拿锁
             */


            ////检验任务状态
            //if(timerTask.getStatus() != XTimerTask.ORIGIN){
            //    throw new IllegalStateException("task already scheduled or cancelled ");
            //}

            //获得操作任务调度时间的权力
            synchronized (timerTask.lock){
                mergeToTask(timerTask,config);
            }


            taskQueue.add(timerTask);
            //如果是第一个任务,则需要唤醒消费线程，因为队列空的时候，它还在等待
            if(taskQueue.getFirst() == timerTask){
                this.taskQueue.notify();
            }
        }
    }


    public void cancel(){

        synchronized (taskQueue){

            /**
             * 为什么这里不用对taskConsumeThread 加锁？因为taskConsumeThread 是一个被TimerSchedule  私有的线程 并且它自己不会操作这个状态位
             *
             * */
            //任务不再继续被调度
            taskConsumeThread.newTaskAccepted = false;


            //清空队列中所有的任务，但是如果此时消费线程正在执行某个任务，那么不会影响这个任务的当次执行，但这个任务肯定不会有下次执行了
            taskQueue.clear();

            /**
             * 为什么这里要唤醒？
             *
             * 因为此时 消费线程正在休眠等待，由于最近一个任务的执行时间还未到，它至少会一直休眠到下一个任务的执行时刻，而这个时刻是不可确定的，万一用户设定了一万年，呵呵，这个线程就会永远休眠，即使任务队列其实已经被清空
             */
            taskQueue.notify();
        }
    }

    /**
     * 扫除 队列中所有已经取消的任务，虽然已经取消任务不会再被调度，但还是会占空间
     */
    public int purge(){
        synchronized (taskQueue) {
            return taskQueue.purge();
        }
    }




    private void mergeToTask(XTimerTask timerTask,ScheduleConfig config) {

        //检验任务状态
        if (timerTask.getStatus() != XTimerTask.ORIGIN) {
            throw new IllegalStateException("task already scheduled or cancelled ");
        }

        long nextExecutionTime;
        long period;


        nextExecutionTime = config.getNextExecutionTime();
        period = config.getPeriod() == null ? 0 : config.getPeriod();

        timerTask.setNextExecutionTime(nextExecutionTime);
        timerTask.setPeriod(period);
        timerTask.setStatus(XTimerTask.SCHEDULED);

    }

}
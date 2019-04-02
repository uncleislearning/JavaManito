/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.taskScheduling.MyTimer;

/**
 * 任务执行线程（池）
 *
 * @author xiaomengning
 * @version $Id: XTimerThread.java, v 0.1 2019年03月28日 20:21 xiaomengning Exp $
 */
public class XTimerThread extends Thread {


    public boolean newTaskAccepted = true;


    private XTaskQueue taskQueue;

    public XTimerThread(XTaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    /**
     * 遍历taskqueue
     */
    private void taskLoop() {
        while (true) {
            try {

                // 线程被终止，跳出循环，结束
                if(!newTaskAccepted){
                    break;
                }


                boolean taskFired;
                XTimerTask firstTask;

                //0. 先拿队列锁，防止正在提交任务
                synchronized (taskQueue) {

                    //1. 没有任务，线程休眠

                    /**
                     * 这里为什么不能用if 而是用while ，因为无法保证 线程醒来以后，队列中就会有任务？ 队列是否还允许调度任务？所以用while，线程醒来以后再次判断条件
                     */
                    //if (taskQueue.isEmpty() && newTaskAccepted) {
                    //    this.wait();
                    //}

                    while(taskQueue.isEmpty() && newTaskAccepted){
                        this.taskQueue.wait();
                    }

                    /**
                     * 为什么这里不能直接remove，原因是如果任务没有触发，你先将任务移除了之后就找不到了
                     */
                    //firstTask = taskQueue.removeMin();

                    firstTask = taskQueue.getFirst();
                    long currentTime = System.currentTimeMillis();

                    //避免有其他的线程正在修改任务状态、属性，而不是避免有其他线程正在执行任务
                    synchronized (firstTask.lock) {
                        //检查任务是否需要触发执行，只是修改状态，而非真正的执行任务
                        taskFired = checkAndExecutionSchedule(firstTask,currentTime);
                    }

                    //任务没有触发，则让线程休眠一段时间，释放等待队列的锁，之后被唤醒之后还是会首先去争夺队列的锁
                    if(firstTask.getStatus()==XTimerTask.SCHEDULED && !taskFired){
                        this.taskQueue.wait(firstTask.getNextExecutionTime()-currentTime);
                    }

                }

                //任务触发，则执行任务
                if(taskFired){
                    firstTask.run();
                }
                /**
                 * 为什么不在这里让线程等待？？  因为释放队列的锁 的前提是 你必要拿到了队列的锁，也就是进入到synchronized关键字内
                 */
                //else
                //    //任务没有触发，则等待到任务执行的时刻
                //    this.taskQueue.wait(firstTask.getNextExecutionTime()-currentTime);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkAndExecutionSchedule(XTimerTask firstTask,long c) {



        long nextExecutionTime = firstTask.getNextExecutionTime();

        //已经到了执行时间
        if (firstTask.getStatus() == XTimerTask.SCHEDULED && nextExecutionTime <= c) {

            //检查是否是周期性任务
            if (firstTask.getPeriod() > 0) {
                firstTask.resetExecutionTime();
                taskQueue.removeMin();
                //再次将任务加入队列
                taskQueue.add(firstTask);
            }

            /**
             * 为什么不要在synchronized中执行任务？？防止任务无法终结，导致在等待队列的线程无法被唤醒
             * 你能不能执行得完不要紧，但是你不能影响到让其他线程都无法正常工作
             */
            ////执行任务
            //firstTask.run();
            //
            //单次任务将状态设置为执行完毕
            if(firstTask.getPeriod() == 0L){
                taskQueue.removeMin();
                firstTask.setStatus(XTimerTask.EXECUTED);
            }


            return true;
        }


        //将已经取消的任务移除队列
        if(firstTask.getStatus()==XTimerTask.CANCELLED){
            taskQueue.removeMin();
        }


        //还未到执行时间 或者 任务已经被取消
        return false;
    }

    @Override
    public void run() {
        try {
            taskLoop();
        } finally {
            //线程被终止了

            //清理现场
            synchronized (taskQueue){

                newTaskAccepted = false;

                taskQueue.clear();
            }
        }
    }
}
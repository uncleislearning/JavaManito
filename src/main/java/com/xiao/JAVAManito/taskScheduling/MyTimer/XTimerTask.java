/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.taskScheduling.MyTimer;


/**
 * 任务的抽象
 *
 * @author xiaomengning
 * @version $Id: XTimerTask.java, v 0.1 2019年03月28日 20:18 xiaomengning Exp $
 */
public abstract class XTimerTask implements Runnable {


    /**
     * for Test
     */
    public static XTimerTask getInstance(){
        return new TimerTaskTest();
    }


    /**
     * 用于控制下面属性的锁
     */
    public Object lock = new Object();

    /**
     * 任务当前的状态
     */
    private int status = ORIGIN;

    /**
     *  任务状态枚举
     */

    /**
     * 初始状态
     */
    protected static int ORIGIN = 0;


    /**
     * 已被调度，再任务队列中等待执行
     */
    protected static int SCHEDULED = 1;

    /**
     * 执行完毕
     */
    protected static int EXECUTED= 2;

    /**
     * 已被取消
     */
    protected static int CANCELLED = 3;


    /**
     * 下一次的时间
     */
    protected long nextExecutionTime;

    /**
     * 周期任务执行间隔
     */
    protected long period;

    /**
     * 取消任务
     * @return true  代表  是 将SCHEDULED的任务 正确的 变成了 CANCELLED
     */
    public boolean cancel(){

        synchronized (lock){
            boolean result  = (status == SCHEDULED);

            this.status = CANCELLED;

            return result;
        }
    }



    public void resetExecutionTime(){
        if(period>0){
            nextExecutionTime+=period;
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getNextExecutionTime() {
        return nextExecutionTime;
    }

    public void setNextExecutionTime(long nextExecutionTime) {
        this.nextExecutionTime = nextExecutionTime;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }


    private static class TimerTaskTest extends XTimerTask{

        @Override
        public void run() {

        }
    }
}
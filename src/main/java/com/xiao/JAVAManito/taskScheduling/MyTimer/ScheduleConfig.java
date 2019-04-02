/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.taskScheduling.MyTimer;

import java.util.Date;

/**
 * 调度配置类
 * @author xiaomengning
 * @version $Id: ScheduleConfig.java, v 0.1 2019年03月28日 20:20 xiaomengning Exp $
 */
public class ScheduleConfig {


    /**
     * 指定下一次的执行时间点
     */
    private Date nextExecutionDate;

    /**
     * 系统当前时间往后延迟delay时间再执行
     */
    private Long delay;

    /**
     * 周期性任务，每个period时间执行一次  period == null 表示为单次任务执行
     */
    private Long period;

    /**
     * 任务下一次执行的时间点
     */
    private Long nextExecutionTime;


    public ScheduleConfig() {
        this(null,null,null);
    }


    public ScheduleConfig(Date nextExecutionDate) {
        this(nextExecutionDate,null,null);
    }

    public ScheduleConfig(Long delay) {
        this(null,delay,null);
    }


    public ScheduleConfig(Long delay,Long period) {
        this(null,delay,period);
    }

    public ScheduleConfig(Date nextExecutionDate,Long period){
        this(nextExecutionDate,null,period);
    }

    public ScheduleConfig(Date nextExecutionDate, Long delay, Long period) {
        this.nextExecutionDate = nextExecutionDate;
        this.delay = delay;
        this.period = period;
        fixNextExecutionTime();
        validate(this);

    }

    private void fixNextExecutionTime() {
        if(nextExecutionDate!=null){
            this.nextExecutionTime = this.nextExecutionDate.getTime();
        }else if(delay!=null&&delay>=0){
            this.nextExecutionTime = this.delay+System.currentTimeMillis();
         }
    }

    public Date getNextExecutionDate() {
        return nextExecutionDate;
    }

    public void setNextExecutionDate(Date nextExecutionDate) {
        this.nextExecutionDate = nextExecutionDate;
    }

    public Long getDelay() {
        return delay;
    }

    public void setDelay(Long delay) {
        this.delay = delay;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getNextExecutionTime() {
        return nextExecutionTime;
    }

    private void validate(ScheduleConfig config){

        if(config.getNextExecutionDate() == null && config.getDelay() == null){
            throw new IllegalArgumentException("execution time is null");
        }

        //如果用户执行的执行时间为过去时间点，则报错
        if(config.getNextExecutionDate()!=null && config.getNextExecutionDate().getTime()<0){
            throw new IllegalArgumentException("next execution date can't be negative ");
        }

        //如果用户设置的延迟时间不是正数，则报错
        if(config.getDelay()!=null && config.getDelay()<0){
            throw new IllegalArgumentException("delay time can't be negative");
        }

        //周期行任务的时间间隔 不能为负数
        if(config.getPeriod()!=null && config.getPeriod()<=0){
            throw new IllegalArgumentException(" period time of repeat task  can't be zero or negative ");
        }
    }





}

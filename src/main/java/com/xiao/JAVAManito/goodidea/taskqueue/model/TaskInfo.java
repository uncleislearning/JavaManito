package com.xiao.JAVAManito.goodidea.taskqueue.model;

import com.xiao.JAVAManito.goodidea.taskqueue.enums.TaskStatusEnum;

import java.util.Date;

/**
 * Created by unclexiao on 22/07/2018.
 */
public class TaskInfo {
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    public Integer getExecuteTimes() {
        return executeTimes;
    }

    public void setExecuteTimes(Integer executeTimes) {
        this.executeTimes = executeTimes;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getExecuteCost() {
        return executeCost;
    }

    public void setExecuteCost(Integer executeCost) {
        this.executeCost = executeCost;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    private String taskId;

    /***
     * 任务状态
     */
    private TaskStatusEnum status;

    /***
     * 执行次数
     */
    private Integer executeTimes;

    /***
     * 任务优先级  0~10  越小优先级越高
     */
    private Integer priority;



    private String message;

    /**
     * 运行持续的时间
     */
    private Integer executeCost;


    /**
     * 任务调度的时间
     */
    private Date scheduleTime;


    /**
     * 任务运行日志
     */
    private String log;
}

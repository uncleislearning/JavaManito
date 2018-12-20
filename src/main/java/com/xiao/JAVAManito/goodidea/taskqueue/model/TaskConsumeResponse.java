package com.xiao.JAVAManito.goodidea.taskqueue.model;

/**
 * Created by unclexiao on 22/07/2018.
 */
public class TaskConsumeResponse {

    /**
     * 任务运行日志
     */
    private String log;
    private Integer priority;

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}

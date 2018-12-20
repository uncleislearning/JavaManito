package com.xiao.JAVAManito.goodidea.taskqueue.model;

/**
 * Created by unclexiao on 22/07/2018.
 */
public class TaskProducerRequest {

    private String message;

    private Integer priority;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}

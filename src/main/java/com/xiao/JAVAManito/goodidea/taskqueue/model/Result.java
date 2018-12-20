package com.xiao.JAVAManito.goodidea.taskqueue.model;

/**
 * Created by unclexiao on 22/07/2018.
 */
public class Result<T> {

    private boolean success;

    private String errorMsg;

    T data;


    public Result() {
    }

    public Result(boolean success, String errorMsg, T data) {
        this.success = success;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

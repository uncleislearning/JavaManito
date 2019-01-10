/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework;

/**
 *
 * @author xiaomengning
 * @version $Id: Result.java, v 0.1 2018年12月25日 21:38 xiaomengning Exp $
 */
public class Result<T> {
    T data;
    boolean isSuccess;
    String error;

    public Result(T data) {
       this(data,true,"");
    }


    public Result(boolean isSuccess,String error){
        this(null,isSuccess,error);
    }


    public Result(T data,boolean isSuccess,String error) {
        this.data = data;
        isSuccess = isSuccess;
        error=error;
    }
}
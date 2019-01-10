/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework;

/**
 *
 * @author xiaomengning
 * @version $Id: ResultFactory.java, v 0.1 2018年12月25日 21:39 xiaomengning Exp $
 */
public class ResultFactory {

    public static Result buildSuccess(){
        return new Result(true);
    }


    public static Result buildData(Object data){
        return new Result(data);
    }

    public static Result buildFail(String errorMessage){
        return new Result(null,false,errorMessage);
    }

}
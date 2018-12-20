package com.xiao.JAVAManito.RPC.demo1;

import java.io.Serializable;
import java.net.Socket;

/**
 * Created by unclexiao on 19/12/2018.
 * 请求类
 */
public class Request implements Serializable {
    public String serviceName;
    public String serviceVersion;
    public String methodName;
    public Class[] argsType;
    public Object[] args;

    public Request(String serviceName, String serviceVersion, String methodName, Object[] args, Class[] argsType) {
        this.serviceName = serviceName;
        this.serviceVersion = serviceVersion;
        this.methodName = methodName;
        this.args = args;
        this.argsType = argsType;
    }
}

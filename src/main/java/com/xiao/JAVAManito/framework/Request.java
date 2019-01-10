/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework;

import java.util.Objects;

/**
 *
 * @author xiaomengning
 * @version $Id: Request.java, v 0.1 2019年01月07日 21:02 xiaomengning Exp $
 */
public class Request {

    /**
     * 请求方法:GET \POST \...
     */
    private String requestMethod;

    /**
     * 请求路径 URL   /something
     */
    private String requestPath;



    public Request(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Request request = (Request) o;
        return Objects.equals(requestMethod, request.requestMethod) &&
                Objects.equals(requestPath, request.requestPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestMethod, requestPath);
    }
}
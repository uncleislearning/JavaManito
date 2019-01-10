/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework;

import java.util.Map;

/**
 *
 * 封装 http请求的参数与值的映射，提供一批方法 便于取参数的值
 * @author xiaomengning
 * @version $Id: Param.java, v 0.1 2019年01月07日 21:45 xiaomengning Exp $
 */
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public String getString(String paramName){
        return (String) paramMap.get(paramName);
    }
}
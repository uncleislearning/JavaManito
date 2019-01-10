/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework;

import java.lang.reflect.Method;

/**
 *
 * @author xiaomengning
 * @version $Id: Handler.java, v 0.1 2019年01月07日 21:04 xiaomengning Exp $
 */
public class Handler {
    private Class<?> controllerClass;

    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }
}
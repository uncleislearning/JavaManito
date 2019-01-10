/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.helper;

import com.xiao.JAVAManito.framework.Handler;
import com.xiao.JAVAManito.framework.Request;
import com.xiao.JAVAManito.framework.annotations.Action;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * 请求 -- 处理的映射
 *
 *
 * @author xiaomengning
 * @version $Id: ControllerHelper.java, v 0.1 2019年01月07日 21:00 xiaomengning Exp $
 */
public class ControllerHelper {

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();


    static {
        Set<Class<?>> controllerClsSet = ClassHelper.getControllerClassSet();
        for(Class<?> contrllerCls:controllerClsSet ){
            Method[] methods = contrllerCls.getMethods();
            for(Method method : methods){
                if(method.isAnnotationPresent(Action.class)){
                    Action action = method.getDeclaredAnnotation(Action.class);
                    String mapping = action.value();

                    //处理URL规则
                    if(mapping.matches("\\w+:/\\w*")){
                        String[] array = mapping.split(":");
                        if(array!=null && array.length==2){
                            String requestMethod = array[0];
                            String requestPath = array[1];
                            Request actionRequest = new Request(requestMethod,requestPath);
                            Handler actionHandler = new Handler(contrllerCls,method);
                            ACTION_MAP.put(actionRequest,actionHandler);
                        }
                    }
                }
            }
        }
    }


    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);

        return ACTION_MAP.get(request);
    }

}
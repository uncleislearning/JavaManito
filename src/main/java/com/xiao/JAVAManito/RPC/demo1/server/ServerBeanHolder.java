package com.xiao.JAVAManito.RPC.demo1.server;

import java.util.HashMap;

/**
 * Created by unclexiao on 19/12/2018.
 *
 * 服务bean的映射
 */
public class ServerBeanHolder {

    private static final HashMap<String,Object> beanHolder = new HashMap<>();

    private static final String splitFlag = "+";

    static {
        beanHolder.put("CalculatorService+1",new CalculatorServiceImpl());
        beanHolder.put("CalculatorService+2",new CalculatorServiceImplV2());
    }

    public static Object getBeanByNameAndVersion(String serviceName,String version){
        return beanHolder.get(serviceName+splitFlag+version);
    }

}

/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.goodidea.spi;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 *
 * @author xiaomengning
 * @version $Id: XDriverManager.java, v 0.1 2019年04月02日 21:24 xiaomengning Exp $
 */
public class XDriverManager {

    private static HashMap<String,Class<? extends XDriver>> registered = Maps.newHashMap();

    public static void register(String driverName,Class<? extends XDriver> driver){
        if(driverName == null || driver==null){
            throw new IllegalArgumentException("drivername and driver can't not be null");
        }
        registered.put(driverName,driver);
    }


    public static XDriver getInstance(String driverName){
        if(driverName == null){
            throw new IllegalArgumentException("drivername  can't not be null");
        }
        Class<? extends XDriver> driverClass = registered.get(driverName);

        XDriver driver = null;
        try {
            driver = driverClass==null?null:driverClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return driver;
    }


}
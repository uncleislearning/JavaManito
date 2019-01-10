/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.helper;

import com.xiao.JAVAManito.framework.AppConstant;

import java.util.Properties;

import static com.xiao.JAVAManito.framework.util.ConfigUtil.loadFromFile;

/**
 *
 *
 * 配置文件相关操作的工具类
 * @author xiaomengning
 * @version $Id: ConfigHelper.java, v 0.1 2018年12月25日 21:54 xiaomengning Exp $
 */
public final class ConfigHelper {

    private static final Properties CONFIG_PROPERS;

    /**
     * 加载配置文件
     */
    static {
        CONFIG_PROPERS = loadFromFile("");
    }



    public static String getBasePath(){
       return CONFIG_PROPERS.getProperty(AppConstant.APP_BASE_PATH);
    }


    /**
     * 通过配置项名称 获取对于的配置值
     */




}
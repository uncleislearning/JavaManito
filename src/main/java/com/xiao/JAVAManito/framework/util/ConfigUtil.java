/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.util;

import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author xiaomengning
 * @version $Id: ConfigUtil.java, v 0.1 2019年01月07日 20:06 xiaomengning Exp $
 */
public final class ConfigUtil {


    public static Properties loadFromFile(String path){
        Properties properties = new Properties();

        try {
            if(StringUtils.isEmpty(path)){
                properties.load(new FileReader("resources.properties"));
            }else {
                properties.load(new FileReader(path));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
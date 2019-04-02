/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.goodidea.spi;

import com.xiao.JAVAManito.goodidea.spi.provider.MySQLDriver;
import com.xiao.JAVAManito.goodidea.spi.provider.OracleDriver;

/**
 *
 * @author xiaomengning
 * @version $Id: Client.java, v 0.1 2019年04月02日 21:23 xiaomengning Exp $
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException {


        Class.forName("com.xiao.JAVAManito.goodidea.spi.provider.MySQLDriver");

        XDriver xDriver = XDriverManager.getInstance("driver.Mysql");

        System.out.println(xDriver instanceof MySQLDriver );



        Class.forName("com.xiao.JAVAManito.goodidea.spi.provider.OracleDriver");

        xDriver = XDriverManager.getInstance("driver.Oracle");

        System.out.println(xDriver instanceof OracleDriver);
    }
}
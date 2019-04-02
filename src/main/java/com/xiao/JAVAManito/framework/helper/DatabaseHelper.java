/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author xiaomengning
 * @version $Id: DatabaseHelper.java, v 0.1 2019年02月02日 21:08 xiaomengning Exp $
 */
public final class DatabaseHelper {


    private static Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/demo";
    private static final String username = "unclexiao";
    private static final String password = "123445";


    //多线程环境下，让各个线程只操作自己的连接
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal();

    public static Connection getConnection()  {
        Connection conn  = connectionThreadLocal.get();
        try {
            if(conn == null){
                Class.forName(driver);
                conn = DriverManager.getConnection(url,username,password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error("get connnection error:"+e);
            throw new RuntimeException(e);
        }finally {
            connectionThreadLocal.set(conn);
        }
        return conn;
    }

    public static void closeConnection() {
        Connection conn = connectionThreadLocal.get();
        try {
            if(conn != null){
                conn.close();
            }
        }catch (SQLException e) {
            LOGGER.error("close connnection error:"+e);
            throw new RuntimeException(e);
        } finally {
            connectionThreadLocal.remove();
        }
    }


    /**
     * 开启事务
     */

    public static void beginTransactional()  {
        Connection conn = getConnection();
        if(conn!=null){
            try {
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                LOGGER.error("begin transaction failure:"+e);
                throw new RuntimeException(e);
            }finally {
                connectionThreadLocal.set(conn);
            }
        }
    }

    /**
     * 提交事务
     */
    public static void commitTransaction(){
        Connection conn = getConnection();
        if(conn !=null){
            try {
                conn.commit();
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("commit transaction failure:"+e);
                throw new RuntimeException(e);
            }finally {
                connectionThreadLocal.remove();
            }

        }
    }

    /**
     * 回滚事务
     */

    public static void rollbackTransaction(){
        Connection conn =getConnection();
        if(conn!=null){
            try {
                conn.rollback();
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("rollback transaction failure:"+e);
                throw new RuntimeException(e);
            }finally {
                connectionThreadLocal.remove();
            }
        }
    }
}
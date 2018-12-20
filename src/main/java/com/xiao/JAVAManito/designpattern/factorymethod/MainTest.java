package com.xiao.JAVAManito.designpattern.factorymethod;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class MainTest {
    public static void main(String[] args) {
        LoggerFactory loggerFactory;
        Logger logger;
        //可以引入配置文件实现，从而避免使用new
        loggerFactory = new FileLoggerFactory();


        logger = loggerFactory.createLogger();
        logger.writeLog();


        loggerFactory = new DatabaseLoggerFactory();
        logger = loggerFactory.createLogger();
        logger.writeLog();
    }
}

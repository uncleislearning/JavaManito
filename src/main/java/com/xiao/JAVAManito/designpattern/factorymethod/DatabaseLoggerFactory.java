package com.xiao.JAVAManito.designpattern.factorymethod;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        //dataLogger特殊的一些操作（初始化、读配置文件之类的）
        Logger logger = new DatabaseLogger();
        return logger;
    }
}

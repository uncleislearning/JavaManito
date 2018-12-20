package com.xiao.JAVAManito.designpattern.factorymethod;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        //其他该logger的特定操作
        Logger logger = new FileLogger();
        return logger;
    }
}

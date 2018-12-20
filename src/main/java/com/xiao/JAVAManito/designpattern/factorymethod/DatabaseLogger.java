package com.xiao.JAVAManito.designpattern.factorymethod;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("正在写数据库日志");
    }
}

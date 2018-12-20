package com.xiao.JAVAManito.RPC.demo1;


import com.xiao.JAVAManito.RPC.demo1.server.EventHandler;
import com.xiao.JAVAManito.RPC.demo1.server.EventHandlerMultithread;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by unclexiao on 19/12/2018.
 * 模拟服务端启动
 */
public class AppServerTest {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
//        //模拟 启动服务 ,先启动服务
//        EventHandler.eventHandler();


        //模拟 启动服务，多线程
        EventHandlerMultithread.eventHandler();
    }
}

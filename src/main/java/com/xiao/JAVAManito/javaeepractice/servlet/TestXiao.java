package com.xiao.JAVAManito.javaeepractice.servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by unclexiao on 2018/1/3.
 */
@WebListener
public class TestXiao implements ServletRequestListener{
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("TestXiao Listener");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("TestXiao Listener");
    }
}

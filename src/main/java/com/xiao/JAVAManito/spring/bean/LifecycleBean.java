package com.xiao.JAVAManito.spring.bean;

import org.springframework.context.Lifecycle;

/**
 * Created by unclexiao on 14/05/2018.
 */
public class LifecycleBean implements Lifecycle {
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}

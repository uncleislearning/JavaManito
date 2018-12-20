package com.xiao.JAVAManito.spring;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by unclexiao on 14/05/2018.
 *
 * 控制bean的lifecircle 之 bean 初始化 之后 进行动作
 */
@Component
public class TestInitializingBeanWithAnnotation {

    private String name;

    public String getName() {
        return name;
    }

    @Value("default")
    public void setName(String name) {
        this.name = name;
    }



    @PostConstruct
    public void change(){
        this.name = "afterInitialization";
    }
}

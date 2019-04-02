package com.xiao.JAVAManito.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.support.SQLExceptionTranslator;


/**
 * Created by unclexiao on 14/05/2018.
 *
 * 控制bean的lifecircle 之 bean 初始化 之后 进行动作
 */

public class TestInitializingBean implements InitializingBean {

    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = "afterPropertiesSet";
        System.out.println("name:"+this.name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

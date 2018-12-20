package com.xiao.JAVAManito.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Created by unclexiao on 03/04/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-beans.xml"})
public class TestAwareTest {


    @Autowired
    TestAware.UncleBean uncleBean;

    @Test
    public void test(){
        String name = uncleBean.getName();
        System.out.println(name);

        String fname = uncleBean.getFailName();
        System.out.println(fname);

    }

}
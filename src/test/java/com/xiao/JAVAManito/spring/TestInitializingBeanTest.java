package com.xiao.JAVAManito.spring;

import com.xiao.JAVAManito.spring.bean.DestroyBean;
import com.xiao.JAVAManito.spring.bean.DestroyBeanWithAnnotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by unclexiao on 14/05/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-beans.xml"})
public class TestInitializingBeanTest {

    @Autowired
    TestInitializingBean testInitializingBean;


    @Autowired
    TestInitializingBeanWithAnnotation testInitializingBeanWithAnnotation;


    @Autowired
    DestroyBean destroyBean;

    @Autowired
    DestroyBeanWithAnnotation destroyBeanWithAnnotation;
    @Test
    public void afterPropertiesSet() throws Exception {
        System.out.println(testInitializingBean.getName());
    }

    @Test
    public void testInitializingBeanWithAnnotation(){
        System.out.println(testInitializingBeanWithAnnotation.getName());
    }

    @Test
    public void testDestroy(){

    }



}
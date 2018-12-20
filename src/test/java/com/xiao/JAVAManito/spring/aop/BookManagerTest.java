package com.xiao.JAVAManito.spring.aop;

import com.xiao.JAVAManito.spring.aop.exam1.AuthAspect;
import com.xiao.JAVAManito.spring.aop.exam1.BookManager;
import org.aspectj.weaver.Advice;
import org.aspectj.weaver.AjAttribute;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJAdvisorFactory;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.annotation.Retention;

/**
 * Created by unclexiao on 17/04/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-beans.xml"})
public class BookManagerTest {

    @Resource
    BookManager bookManager;

    @Test
    public void testAOP(){
        bookManager.delete();
        bookManager.insert();
    }


    @Test
    public void testProxy(){
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(bookManager);
        proxyFactory.addAspect(AuthAspect.class);
        BookManager bm = proxyFactory.getProxy();

        bm.insert();
        bm.delete();
    }



}

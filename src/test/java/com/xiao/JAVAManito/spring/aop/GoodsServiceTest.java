package com.xiao.JAVAManito.spring.aop;


import com.xiao.JAVAManito.spring.aop.exam1.AuthAspect;
import com.xiao.JAVAManito.spring.aop.exam1.BookManager;
import com.xiao.JAVAManito.spring.aop.exam2.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by unclexiao on 17/04/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-beans.xml"})
public class GoodsServiceTest {

    @Autowired
    GoodsService goodsService;

    @Autowired
    BookManager bookManager;

    @Test
    public void testAOP(){

        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(bookManager);
        proxyFactory.addAspect(AuthAspect.class);
        proxyFactory.setProxyTargetClass(true); //直接代理目标类 ---》CGLIB代理

        BookManager bmProxy =  proxyFactory.getProxy();
        bmProxy.delete();
        bmProxy.insert();
    }

}

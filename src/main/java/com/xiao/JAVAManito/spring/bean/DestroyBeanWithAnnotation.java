package com.xiao.JAVAManito.spring.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.InputStream;

/**
 * Created by unclexiao on 14/05/2018.
 */
@Component
public class DestroyBeanWithAnnotation {
    private InputStream inputStream ;


    @PreDestroy
    public void destroy() throws Exception {
        if(inputStream != null){
            inputStream.close();
        }
        System.out.println("on destruction，do something");
    }
}

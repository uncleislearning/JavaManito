package com.xiao.JAVAManito.spring.bean;

import org.springframework.beans.factory.DisposableBean;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by unclexiao on 14/05/2018.
 */
public class DestroyBean implements DisposableBean {

    private InputStream inputStream ;


    @Override
    public void destroy() throws Exception {
        if(inputStream != null){
            inputStream.close();
        }
        System.out.println("on destruction，do something");
    }
}

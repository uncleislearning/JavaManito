package com.xiao.JAVAManito.spring.aop.exam1;

import org.springframework.stereotype.Component;


/**
 * Created by unclexiao on 17/04/2018.
 */
@Component
public class BookManager {

    @AdminOnly
    public void delete(){
        System.out.println("正在执行删除操作");
    }

    @AdminOnly
    public void insert(){
        System.out.println("正在执行插入操作");
    }
}

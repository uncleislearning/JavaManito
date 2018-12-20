package com.xiao.JAVAManito.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.dao.DataAccessException;

/**
 * Created by unclexiao on 03/04/2018.
 */
public class TestAware {


   public static class UncleBean implements BeanNameAware{
        //bean 的名字 如果有这个需求的话
       private String name;

       private String failName;


       public void afterInit(){
           System.out.println("init 之后");
       }

       public void beforeDestory(){
           System.out.println("I have something special to say before destorying me");
       }

       public String getFailName() {
           return failName;
       }

       public void setFailName(String failName) {
           this.failName = failName;
       }

       public String getName() {
           return name;
       }

       @Override
       public void setBeanName(String s) {
           this.name = s;
       }
   }




}

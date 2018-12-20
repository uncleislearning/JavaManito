package com.xiao.JAVAManito.spring.aop.exam1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by unclexiao on 17/04/2018.
 */
@Component
@Aspect
public class AuthAspect {

    @Autowired
    AuthService authService;

    @Pointcut("@annotation(AdminOnly)")
    public void isAdmin(){

    }
    @Around("isAdmin()")
    public void check(ProceedingJoinPoint joinPoint){
        String identity = "origin";
        try {
            if(authService.isAdmin(identity)){
                joinPoint.proceed();
            }else {
                System.out.println("操作被取消");
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }


}

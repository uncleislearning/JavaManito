package com.xiao.JAVAManito.goodidea.auth.manager;

import com.xiao.JAVAManito.goodidea.auth.annotation.AuthCheck;
import com.xiao.JAVAManito.goodidea.auth.enums.BizTypeEnum;
import com.xiao.JAVAManito.goodidea.auth.enums.OpTypeEnum;

import java.lang.annotation.Annotation;

/**
 * Created by unclexiao on 18/07/2018.
 *
 * 用来产生 AuthCheck
 */
public class AuthCheckFatory {



    public static AuthCheck getAuthCheck(final BizTypeEnum bizTypeEnum, final OpTypeEnum opTypeEnum){

        return new AuthCheck() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return AuthCheck.class;
            }

            @Override
            public BizTypeEnum resourceType() {
                return bizTypeEnum;
            }

            @Override
            public OpTypeEnum opType() {
                return opTypeEnum;
            }
        };
    }
}

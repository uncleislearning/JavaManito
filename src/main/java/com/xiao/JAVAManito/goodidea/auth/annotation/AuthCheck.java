package com.xiao.JAVAManito.goodidea.auth.annotation;

import com.xiao.JAVAManito.goodidea.auth.enums.BizTypeEnum;
import com.xiao.JAVAManito.goodidea.auth.enums.OpTypeEnum;

import java.lang.annotation.*;

/**
 * Created by unclexiao on 18/07/2018.
 *
 * 资源操作权限
 *
 */
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {


    /**
     * 资源类型
     * @return
     */
    BizTypeEnum resourceType() default BizTypeEnum.DEFAULT;


    /**
     * 操作
     * @return
     */
    OpTypeEnum opType();

}

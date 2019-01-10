/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework.helper;

import com.xiao.JAVAManito.framework.annotations.Injection;
import com.xiao.JAVAManito.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 完成 依赖注入功能
 *
 * @author xiaomengning
 * @version $Id: IocHelper.java, v 0.1 2019年01月07日 20:33 xiaomengning Exp $
 */
public class IocHelper {

    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        //遍历bean容器
        for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
            Class<?> cls = entry.getKey();
            Object beanInstance = entry.getValue();

            //遍历每个bean对象所有的field
            Field[] fields = cls.getFields();
            for (Field beanfield : fields) {
                if (beanfield.isAnnotationPresent(Injection.class)) {
                    //说明该bean 有带完成的依赖注入:
                    //找到目标bean对象
                    Class<?> fieldClass = beanfield.getType();
                    Object beanFieldInstance = beanMap.get(fieldClass);
                    if (beanFieldInstance == null) {
                        beanFieldInstance = ReflectionUtil.newInstance(fieldClass);
                        beanMap.put(fieldClass,beanFieldInstance);
                    }
                    //将目标bean对象塞进依赖对象中
                    ReflectionUtil.setField(beanInstance,beanfield,beanFieldInstance);
                }
            }

        }
    }

}
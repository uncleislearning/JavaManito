package com.xiao.JAVAManito.javareflection;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by unclexiao on 21/06/2018.
 *
 * 比较两个类的不同对象，找出不同值的属性
 */
public class ReflectionTest {


    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {


        List<Object> l1 = new LinkedList<>();
        l1.add("ok");
        l1.add('1');

        List<Object> l2 = new LinkedList<>();
        l2.add("liki");
        l2.add('1');

        Animal a = new Animal(12,"tali",l1);
        Animal b = new Animal(12,"dgf",l2);

        Class type = a.getClass();

        Field[] fields = type.getDeclaredFields();

        for(Field field : fields){
            // 怎么通过Field--》拿到对应的getMethod
            PropertyDescriptor prod = new PropertyDescriptor(field.getName(),type);
            Method readMethod = prod.getReadMethod();
            Object one = readMethod.invoke(a);
            Object two = readMethod.invoke(b);

            if(!one.equals(two)){
                System.out.println("属性："+field.getName()+"不一样，a的属性值为："+one+",b的属性值为："+two);
            }
        }
    }
}

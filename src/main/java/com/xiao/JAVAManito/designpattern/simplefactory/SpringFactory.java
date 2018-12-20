package com.xiao.JAVAManito.designpattern.simplefactory;


import javax.ws.rs.core.Configuration;
import java.io.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by unclexiao on 13/03/2018.
 */
public class SpringFactory {

    private Map<Object, Object> factory = new ConcurrentHashMap<>();


    //从配置文件中读取用户配置bean，通过反射动态的创建实例，并放入factory中
    public void init() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.读取配置文件
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(new File("src/main/resources/bean.xml"));
        properties.loadFromXML(inputStream);

        //2.通过bean ID拿到类的全限定名称
        String path1 = properties.getProperty("squareShape");
        String path2 = properties.getProperty("circleShape");

        //3.利用反射生成对象

        SquareShape s = (SquareShape) Class.forName(path1).getConstructor().newInstance();
        CircleShape c = (CircleShape) Class.forName(path2).getConstructor().newInstance();

        //4.放入factory中
        factory.put("squareShape", s);
        factory.put("circleShape", c);

    }


    public Object getBean(String beanId) {
        if (beanId == null)
            return null;
        return factory.get(beanId);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SpringFactory sf = new SpringFactory();
        sf.init();

        SquareShape s = (SquareShape) sf.getBean("squareShape");
        s.draw();
        s.erase();
    }
}

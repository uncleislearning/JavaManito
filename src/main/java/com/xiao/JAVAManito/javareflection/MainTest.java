package com.xiao.JAVAManito.javareflection;


import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class MainTest {



    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        //1.Class Test
        Class t = Class.forName("com.xiao.JAVAManito.javareflection.Animal");
        Object o = t.newInstance();
        if(o instanceof Integer){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        //2.Class Test
        Animal animal = new Animal(12,"dog", Arrays.asList("腿","鼻子"));
        Class t2 = animal.getClass();

        // Method Test
        Method method = t2.getMethod("getAge");


        Object age = method.invoke(animal);
        System.out.println(age);

    }
}

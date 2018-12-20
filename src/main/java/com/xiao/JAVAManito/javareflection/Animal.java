package com.xiao.JAVAManito.javareflection;

import java.util.List;

/**
 * Created by unclexiao on 21/06/2018.
 */
public class Animal {
    private int age;
    private String name;
    private List<Object> component;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Object> getComponent() {
        return component;
    }

    public void setComponent(List<Object> component) {
        this.component = component;
    }

    public Animal() {
    }

    public Animal(int age, String name, List<Object> component) {
        this.age = age;
        this.name = name;
        this.component = component;
    }
}

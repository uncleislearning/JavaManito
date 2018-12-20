package com.xiao.JAVAManito.designpattern.prototype.two;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class ContreteType implements Cloneable {
    private String name;
    private int age;

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

    public ContreteType(String name) {
        this.name = name;
    }

    public ContreteType(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = null;
        try{
            object = super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("not support cloneable");
        }

        return object;

    }
}

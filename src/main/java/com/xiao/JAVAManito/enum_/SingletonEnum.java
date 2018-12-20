package com.xiao.JAVAManito.enum_;



/**
 * Created by unclexiao on 16/05/2018.
 *
 *
 * 单例对象
 */
public enum SingletonEnum {
    INSTANCE("singleton");

    private String name;

    SingletonEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) {
        System.out.println(SingletonEnum.getInstance().getName());
    }
}

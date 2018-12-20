package com.xiao.JAVAManito.objectclone.one;

/**
 * Created by unclexiao on 2017/12/18.
 *
 * 浅克隆示例：
 */
public class Country implements Cloneable{
    private Province province;
    private String name;
    private int id;

    public Country() {
    }

    public Country(Province province, String name, int id) {
        this.province = province;
        this.name = name;
        this.id = id;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object =null;
        try {
            object = super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("not support cloneable");
        }
        return object;
    }
}

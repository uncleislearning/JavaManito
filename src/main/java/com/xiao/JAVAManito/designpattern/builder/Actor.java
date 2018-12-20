package com.xiao.JAVAManito.designpattern.builder;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class Actor {
    private String name;
    private String country;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.country+","+this.name+","+this.type;
    }
}

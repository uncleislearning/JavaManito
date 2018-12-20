package com.xiao.JAVAManito.objectclone.two;

import java.io.Serializable;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class Province implements Serializable{
    private String name;
    private int id;

    public Province(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Province() {
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
}

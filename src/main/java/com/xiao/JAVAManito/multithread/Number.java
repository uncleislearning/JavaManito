package com.xiao.JAVAManito.multithread;

import java.util.concurrent.Callable;

/**
 * Created by unclexiao on 2017/11/19.
 */
public class Number{
    private int num;

    public Number() {
    }

    public Number(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public void subduction(int step){
        this.num-=step;
    }
}

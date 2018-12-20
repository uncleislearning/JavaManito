package com.xiao.JAVAManito.designpattern.adapter;

/**
 * Created by unclexiao on 2017/12/21.
 */
public class MainTest {
    public static void main(String[] args) {
        //客户端操作

        ScoreOpertations opertations;

        //可通过配置文件，当需要使用其他排序和查找算法时，可以新增加适配器类，修改配置文件注入给ScoreOpertations的实现子类即可
        opertations = new OperationAdapter();

        int[] array = new int[]{1,2,3};
        opertations.search(array,1);

        opertations.sort(array);



    }
}

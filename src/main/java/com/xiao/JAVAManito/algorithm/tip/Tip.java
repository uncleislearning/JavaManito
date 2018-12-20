package com.xiao.JAVAManito.algorithm.tip;

/**
 * Created by unclexiao on 02/03/2018.
 */
public class Tip {

    /**
     * 判断是否是闰年
     */

    public static boolean isLeap(int year){
        return (year % 4 ==0 && year % 100 !=0) ||(year % 400 ==0);
    }








}

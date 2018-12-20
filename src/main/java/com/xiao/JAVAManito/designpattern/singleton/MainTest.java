package com.xiao.JAVAManito.designpattern.singleton;

/**
 * Created by unclexiao on 2017/12/17.
 */
public class MainTest {
    public static void main(String[] args) {
       TaskManager taskManager =  TaskManager.getInstance();
       TaskManager taskManager1 = TaskManager.getInstance();
        System.out.println(taskManager == taskManager1);
    }
}

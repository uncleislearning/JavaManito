package com.xiao.JAVAManito.effective.nestedclass;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by unclexiao on 06/06/2018.
 */
public class StaticMemberClass {

    private  String sid;
    private static String name="StaticMemberClass";

    private static String id="llll";


    static class NestedClass{
        private String id;
        private String pwd;


        public NestedClass(String id, String pwd) {
            this.id = id;
            this.pwd = pwd;
        }

        public void touch(){

            /**
             * static member Class 能够拿到外部类所有的static成员
             */
            System.out.println("拿到外部类的成员："+name);
//            System.out.println(sid);

            System.out.println(id);

        }

    }

    public static void main(String[] args) {


        NestedClass nestedClass = new NestedClass("NestedClass","NestedClass");
        nestedClass.touch();
        System.out.println();

    }


}

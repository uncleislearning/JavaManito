package com.xiao.JAVAManito.java8;

import java.io.PrintStream;
import java.util.*;

/**
 * Created by unclexiao on 2017/12/13.
 */
public class TestFeature {

    /**
     * 特性1：接口方法允许给出默认实现，子类实现类仅需要实现接口中其他方法即可
     * @param
     */


    interface Face{
        void say(String something);
        default void  smile(){
            System.out.println("lalala");
        }

    }




    @FunctionalInterface
    interface Move{
        int move(String a, String b);

        public static void say(){
            System.out.println("hihi java8");
        }
    }


    //*******特性1：运行接口的方法有默认实现
    public static void testFeature1(){
        Face face = new Face() {
            @Override
            public void say(String something) {
                System.out.println(something);
            }
        };
        face.smile();
    }


    public static void testFeature2(){
        List<String> list = Arrays.asList("sga3", "134ASg", "age");

        Collections.sort(list,(v1,v2)->-v1.compareTo(v2));
        for (String s : list) {
            System.out.println(s);
        }

    }




    public static int doSome(Move move){
        String a="a";
        String b = "b";
       return move.move(a,b);
    }

    interface Print{
        void print();
    }
    public static void main(String[] args) {



        Print p =  System.out::println;
        p.print();

        int ans =  doSome((a,b) -> 1);
        System.out.println(ans);




    }
}

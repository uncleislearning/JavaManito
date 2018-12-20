package com.xiao.JAVAManito.designpattern.builder;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class MainTest {
    public static void main(String[] args) {
        Actor actor;
        Director director = new Director();

        //天使角色的创建
//        AngelBuilder ab = new AngelBuilder();
//        director.setBuilder(ab);

        //恶魔角色创建
//        DemonBuilder db = new DemonBuilder();
//        director.setBuilder(db);

        //骑士角色创建
        KnightBuilder kb = new KnightBuilder();
        director.setBuilder(kb);


        actor = director.construct();
        System.out.println(actor);


    }
}

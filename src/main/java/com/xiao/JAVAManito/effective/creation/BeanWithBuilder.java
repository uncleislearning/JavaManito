package com.xiao.JAVAManito.effective.creation;


/**
 * Created by unclexiao on 16/05/2018.
 */
public class BeanWithBuilder {
   //必选参数
    private int id;
    private int age;

    //可选参数
    private long timestamp;
    private float price;
    private boolean flag;

    private static class MyBuilder{
        private int id;
        private int age;

        private long timestamp =0;
        private float price = 0;
        private boolean flag = false;


        public MyBuilder(int id, int age) {
            this.id = id;
            this.age = age;
        }

        /**
         * 这些接口 用来设置可选参数
         */

        public MyBuilder timestamp(long timestamp){
            this.timestamp = timestamp;
            return this;
        }

        public MyBuilder price(float price){
            this.price = price;
            return this;
        }
        public MyBuilder flag(boolean flag){
            this.flag = flag;
            return this;
        }

        public BeanWithBuilder build(){
            return new BeanWithBuilder(this);
        }

    }

    /**
       具备了 安全性、可读性
     */
    private BeanWithBuilder(MyBuilder builder){
        this.id = builder.id;
        this.age = builder.age;
        this.flag = builder.flag;
        this.price = builder.price;
        this.timestamp =builder.timestamp;
    }


    public static void main(String[] args) {
        BeanWithBuilder beanWithBuilder = new BeanWithBuilder.MyBuilder(12,12).flag(true).build();
    }

}

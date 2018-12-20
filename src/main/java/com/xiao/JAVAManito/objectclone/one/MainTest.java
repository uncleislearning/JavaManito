package com.xiao.JAVAManito.objectclone.one;

/**
 * Created by unclexiao on 2017/12/18.
 * 浅克隆示例
 */
public class MainTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Country c1 ,c2;

        c1 = new Country();

        c1.setId(1);
        c1.setName("中国");
        Province p1 = new Province("拉萨",12);
        c1.setProvince(p1);

        c2 = (Country) c1.clone();

        //false
        System.out.println(c1 == c2);

        //true
        System.out.println(c1.getProvince() == c2.getProvince());

        //true
        System.out.println(c1.getName() == c2.getName());

    }
}

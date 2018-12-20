package com.xiao.JAVAManito.serialization;



import java.io.IOException;

/**
 * Created by unclexiao on 2017/12/18.
 */
public class MainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        People p = new People("nannan");
        p.setAge("12");

        //子类设置父类继承得到的成员值
        p.setSex("女");

        //对象序列化
        byte[] bytes =  SerializeUtils.transportToBytes(p);
        System.out.println(bytes.length);

        //对象反序列化
        People p2 = (People) SerializeUtils.transportToObject(bytes);

        //序列化保持当时对象的状态，所以反序列化得到的数据一致
        System.out.println(p2.getName());

        //修改static成员值
        People.flag = 10;

        //static修饰的成员不被序列化
        System.out.println(p2.getFlag());

        //transit关键字修饰的成员不被序列化
        System.out.println(p2.getAge());


        //父类没有实现Serializable，子类序列化后，从父类继承得到的成员的值与父类一致（子类修改也无效）
        //父类实现了Serializable，那么子类序列化后得到的值均与子类保持一致（子类的修改有效）
        System.out.println(p2.getSex());


    }

}

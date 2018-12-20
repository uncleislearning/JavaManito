package com.xiao.JAVAManito.objectclone.two;

import java.io.*;

/**
 * Created by unclexiao on 2017/12/18.
 *
 * 浅克隆示例：
 */
public class Country implements Serializable{
    private Province province;
    private String name;
    private int id;

    public Country() {
    }

    public Country(Province province, String name, int id) {
        this.province = province;
        this.name = name;
        this.id = id;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   //使用序列化技术实现深克隆
    public Object deepClone() throws IOException, ClassNotFoundException {
        //将this对象写入到对象流中(this->bytes)

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(this);

        //从对象流中将对象还原，即相同的一个拷贝
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream objectIn = new ObjectInputStream(in);
        return objectIn.readObject();

    }
}

package servlet;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;


/**
 * Created by unclexiao on 2018/1/4.
 */
public class ChatTest {

    public static void test() {
        System.out.println("test static");
    }



    public static class Article{
        public String title;
        public String keywords;
        public final Integer page=1;



        public Article(){

        }

        public Article(String title){
            this.title = title;
        }

        public Article(String title,String keywords){
            this.title = title;
            this.keywords = keywords;
        }

    }



    @Test
    public void test1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        Class c = String.class;
        //Class h = Class.forName("org.lang.String");

        String e = "loe";
        //通过某个类的对象，使用Object类的getClass方法
        Class t = e.getClass();
//        //遍历构造函数
//        Constructor[] constructors = t.getConstructors();
//        for (Constructor con : constructors) {
//            System.out.println(con);
//        }
//
//        //通过反射拿到默认构造器
//        Constructor con = t.getConstructor();
//        Object obj = con.newInstance();
//        System.out.println(obj instanceof String);
//
//        //通过反射拿到其他类型的构造器
//        Constructor con1 = t.getConstructor(byte[].class);
//        Object obj1 = con1.newInstance("123".getBytes());
//        System.out.println(obj1 instanceof String);
//        System.out.println(obj1);


        //通过反射获取类成员信息
//        Field[] fileds = t.getFields();
//        for (Field field : fileds) {
//            System.out.println(field);
//        }
//
//        //获取成员变量信息
//        Field comparator = t.getField("CASE_INSENSITIVE_ORDER");
//
//        //获取成员的名字
//        System.out.println(comparator.getName());
//
//        //获取成员修饰符
//        int modify = comparator.getModifiers();
//
//        if (Modifier.isPublic(modify)) {
//            System.out.println("public");
//        }
//
//        if (Modifier.isStatic(modify)) {
//            System.out.println("static");
//        }
//
//        if(Modifier.isFinal(modify)){
//            System.out.println("final");
//        }
//
//        Article article = new Article("where is my home!");
//
//        //通过类实例获取Class对象
//        Class c = article.getClass();
//
//        //通过成员名称获取Field对象
//        Field field = c.getField("page");
//
//        //修改article实例的title成员的值
////        field.set(article,"where is my destiny！");
//        //field.setInt(article,12);
//
//        field.set(article,new Integer(12));
//
//        System.out.println(article.page);

        Article article = new Article("where is my home!");

        //通过类实例获取Class对象
        Class c = article.getClass();

        //通过成员名称获取Field对象
        Field field = c.getField("page");

//        field.setAccessible(true);

        field.set(c,12);

        System.out.println(article.page);





    }



    @Test
    public void test5(){
       IT i = new IT(1);
        change(i);
        System.out.println(i.getV());
    }


    public void change(IT i){
        i.setV(i.getV()+1);
    }


    public class IT{
        int v;

        public IT(int v) {
            this.v = v;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }
    }

}

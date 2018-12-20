import java.util.Collection;

/**
 * Created by unclexiao on 15/05/2018.
 */
public class ExampleBean {


    //以下这些fields 如何存储

    //实例  值属性
    private long number;

    //实例  引用属性
    private Object name;

    private Collection c;

    //类  引用属性
    private static String info;

    //类  值属性
    private static float aFloat;

    //final 值属性
    private final int fid;


    //final 引用属性
    private final Object object;






    //构造函数什么时候触发
    public ExampleBean(){
        fid = 1;
        object = null;
    }


    //方法如何存储

    //实例方法
    public Object getName(){
        return this.name;
    }


    //类方法
    public static String getInfo(){
        return info;
    }

}

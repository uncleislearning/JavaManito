import com.xiao.JAVAManito.multithread.synchronize.DemoTest;
import org.junit.Test;
import org.springframework.core.convert.converter.ConditionalConverter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by unclexiao on 19/03/2018.
 */
public class TestThreadLocal {


    /**
     * 为线程赋予一个唯一自增的标识ID：类变量+对象变量
     */
    public static class UncleThread extends Thread{

        //类变量
        private static AtomicInteger count = new AtomicInteger();


        //所有对象实例共享一份
        public static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };


        //  private int value;//所有线程都有一份value


        //对象方法
        private int nextId(){
            return count.getAndIncrement();
        }

        //对象成员
        //每个线程实例 唯一个全局ID
        private  int threadId = nextId();


        public int getThreadId(){
            return this.threadId;
        }



        public ThreadLocal getValue(){
            return value;
        }


        public UncleThread() {

        }

        @Override
        public void run() {

            for(int i=0;i<100;i++){
                value.set(value.get()+1);
            }
            System.out.println("thread"+getThreadId()+"最终结果:"+value.get());
        }
    }

    @Test
    public void test(){

        UncleThread t1; //声明

        t1 = new UncleThread(); //类加载过程（类加载、连接（准备阶段为类变量赋默认值）、（类）初始化（为类变量赋值））、类实例化（在堆上分配对象空间并返回对象引用）、对象初始化（）

        int id = t1.getThreadId();

//        System.out.println(id); //类加载过程已经对静态成员变量完成声明、实例化（赋默认值）、初始化（为其进行赋值）


        UncleThread t2 = new UncleThread(); //第二次，不需要进行类加载过程（意味着类变量不会再被赋值一遍），只会执行类实例化、对象初始化过程
        id = t2.getThreadId();
//        System.out.println(id);


        System.out.println(t1.getValue() == t2.getValue());



    }





    @Test
    public void testThreadLocal(){
        for(int i=0;i<10;i++){
            new UncleThread().start();
        }
    }




    @Test
    public void testArrayList(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("sgd");
        list.add(-1);



        Iterator itr = list.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }


        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }


        for(Object o : list){
            System.out.println(o);
        }

        Object[] obj = new Object[3];

        System.out.println(obj[-1]);

    }


}

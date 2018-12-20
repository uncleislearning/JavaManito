package servlet;

import org.junit.Test;

import javax.management.monitor.Monitor;
import java.util.*;

/**
 * Created by unclexiao on 31/03/2018.
 */
public class TmpTest {

    @Test
    public void test() {
        ArrayList list = new ArrayList(10);
//        list.add(null);


        list.add("12");
        list.add("12");
        list.add("12");
        list.add("12");
        list.add("12");
        list.add("12");

        String[] strs = (String[]) list.toArray(new String[0]);

        TreeMap treeMap = new TreeMap();


        for (String s : strs) {
            System.out.println(s);
        }
    }


    @Test
    public void testLinkedList() {

        LinkedList ls = new LinkedList();

        ls.add("1");
        ls.add("2");
        ls.add(3,"3");

        ls.remove();
        ls.remove("1");
        ls.remove(1);

        ls.get(1);







        LinkedList stack = new LinkedList();

        stack.push("34");
        stack.push("AGS");
        stack.push("￥%#S");
        stack.push("#jsdgids");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("***********");

        Stack stack1 = new Stack();
        stack1.push("34");
        stack1.push("AGS");
        stack1.push("￥%#S");
        stack1.push("#jsdgids");

        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }

        System.out.println("***********");

        //从队后面添加元素，从队头取出元素(FIFO)
        LinkedList queue = new LinkedList();

        queue.add("1");
        queue.add("2");
        queue.add("3");

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        System.out.println("***********");

        Queue queue1 = new ArrayDeque();

        queue1.add("1");
        queue1.add("2");
        queue1.add("3");


        while (!queue1.isEmpty()){
            System.out.println(queue1.peek());
        }




    }



    @Test
    public void testObject(){

        Object o = new Object();
        Object v = new Object();

        System.out.println(o==v);  //false
        System.out.println(v.hashCode()==o.hashCode()); //false
        System.out.println(o.equals(v));//false



        System.out.println("********");




        String a = "abc";
        String b = new String("abc");

        System.out.println(a==b); //false  == 判断的是两个引用是否指向同一个堆内存地址

        System.out.println(a.hashCode()==b.hashCode()); //true  String类型hashCode计算是依据字符串内容来的，字符串内容相同则计算出来的hashCode一定相同

        System.out.println(a.equals(b)); //true String 类型equals 比较的是内容，内容相同则为true



        System.out.println("********");

        HashMap m = new HashMap();
        HashMap k = new HashMap();


        System.out.println(m.hashCode()); //true
        System.out.println(m.equals(k));//true





    }




}

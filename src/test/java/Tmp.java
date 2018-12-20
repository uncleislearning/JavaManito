import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.util.SocketUtils;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by unclexiao on 11/04/2018.
 */
public class Tmp {


    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null)
            return null;

        ListNode pre=null;
        ListNode tmp;
        ListNode cur = listNode;
        while(cur!=null){
            tmp=cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(pre!=null){
            System.out.println(pre.val);
            res.add(pre.val);
            pre = pre.next;
        }
        return res;

    }

    @Test
    public void test2(){
        ListNode rail = new ListNode(1,null);
        ListNode t1 = new ListNode(4,rail);
        ListNode t2 = new ListNode(6,t1);
        ListNode head = new ListNode(10,t2);


        ArrayList re = printListFromTailToHead(head);

        for(Object a : re){
            System.out.println(a);
        }
    }




    @Test
    public void test(){

      String a = "we are happy";
      String b = a.replace(" ","%20");
        System.out.println(b);

    }


    //通过观察丑数的规律，直接产生前n个丑数
    public int nthUglyNumber2(int n){
       int[] ugly = new int[n+2];
       ugly[0]=1;
       int num_2=0;
       int num_3=0;
       int num_5=0;

       //直接产生前n个丑数
       for(int i=1;i<=n;i++){
           //最小的那个
           ugly[i] = Math.min(Math.min(ugly[num_2]*2,ugly[num_3]*3),ugly[num_5]*5);

           //刚开始种子是1
           if(ugly[i] % 2 ==0){
               num_2++;
           }
           if(ugly[i] % 3 ==0){
               num_3++;
           }
           if(ugly[i] % 5 ==0){
               num_5++;
           }

       }

       return ugly[n-1];

    }





    public int nthUglyNumber(int n) {
        // write your code here

        //产生前n个丑数数组

        int[] chou = new int[n+2];
        int k=0;
        //认为1是丑数
        chou[k++]=1;

        for(int num=2;k<=n;num++){
            //判断是否是丑数
            if(isChou(num)){
                chou[k++] = num;
            }
        }



        return chou[n-1];
    }


    private boolean chouer(int num){
        if(num % 2 ==0 || num % 3 == 0 || num % 5 == 0){
            return true;
        }
        return false;
    }

    private boolean isChou(int num) {

        if(num ==1) return true;

        if(!chouer(num)) return false;

        while(chouer(num)) { //如何让一个丑数更快的到1

            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            }
        }

        if(num == 1){
            return true;
        }else {
            return false;
        }
    }



    @Test
    public void tmp(){

//        //当自动装箱对象存在时，将直接引用现有的包装对象
//        Long a = 1L;
//        Long b = 1L;
//
//        System.out.println(a==b);
//
//
//
//        Long c = 1L;
//        Long d = c;
//
//        //当自动装箱对象不存在时，会新创建一个新对象
//        c = c+1L;
//
//        System.out.println(c==d);


        String[] arr = "sghig_".split(",");

        System.out.println(arr[0]);
    }



    @Test
    public void testTryCatch(){
        try {
            long a = (Long )null;
            System.out.println("try");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("catch");

        }

        System.out.println("catch 外");


    }


//     class Node implements Serializable{
//        private int id;
//        private String name;
//
//
//        public Node() {
//        }
//
//        public Node(int id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }








    @Test
    public void testFastJson(){


        //1. 对象 属性 能够被触及（get方法或者public修饰）
        //2. 需要无参构造函数

        List<Node> nodes = Lists.newArrayList();
        Node a = new Node();
        a.setId(1);
        a.setName("ab");
        nodes.add(a);


        Node b = new Node();
        b.setId(1);
        b.setName("ab");
        nodes.add(b);

        Node c = new Node();
        c.setId(1);
        c.setName("ab");
        nodes.add(c);

        String json = JSON.toJSONString(nodes);
        System.out.println(json);
        List<Node> newN = JSON.parseArray(json,Node.class);

        System.out.println(newN);


    }

    @Test
    public void testComparable(){


        /**
         *  理解  相当对对一个list进行冒泡排序，判断的条件是
         *  if (compare(o1,o2)==1)
         *      swap(o1,o2)
         */
        List<Date> a = new ArrayList<>();
        a.add(new Date(123123123L));
        a.add(new Date(123123L));
        Collections.sort(a, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.before(o2) ? 1 :-1;
            }
        });

        System.out.println(a);






        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(-1);
        b.add(-2);
        Collections.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        });
        System.out.println(b);



    }



    static class ModelT{
        boolean a;
        String c;
        int b;

        public boolean isA() {
            return a;
        }

        public void setA(boolean a) {
            this.a = a;
        }



        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

        public ModelT(boolean a, String c, int b) {
            this.a = a;
            this.c = c;
            this.b = b;
        }
    }

    @Test
    public void testJson(){
        ModelT t = new ModelT(true,"ab",3);
        String  s = JSON.toJSONString(t);
        System.out.println(s);
    }



    private static class Result<T> {
        T data;
        boolean success = true;

        public Result(T data, boolean success) {
            this.data = data;
            this.success = success;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }

    @Test
    public void testJ(){
        Result<Integer> result = getResult();

        if(result.getData() instanceof Integer){
            System.out.println(result.getData());
        }


    }



    private Result getResult(){

        return new Result(new Exception("啦啦啦啦啦"),false);
    }


}

package com.xiao.JAVAManito.effective.implementmethod;

/**
 * Created by unclexiao on 27/05/2018.
 */
public class CloneableComparableObject implements Cloneable,Comparable<CloneableComparableObject>{

    /**
     * 关于Cloneable接口的几个小知识点：
     * <p>
     * 1. Cloneable接口 标识接口，表示对象可克隆
     * 2. 接口本身并没有提供 clone方法，所以如果仅仅实现Cloneable接口而没有重写Object中的clone方法，将会报出异常CloneNotSupportedException
     * <p>
     * 3. 构造一个可克隆类的正确地做法，实现Cloneable接口，重写Object的clone方法，并将访问权限改为public
     */
    private static class SampleClone implements Cloneable {


        private Object[] elements;
        private String name;
        private int age;

        //需要深拷贝，每个bucket中是一条MyEntry链
        private MyEntry[] buckets;
        //bucketsz中存放的元素个数
        private int size;

        public SampleClone() {

        }

        public SampleClone(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public Object clone(){

            try {
                SampleClone another = (SampleClone) super.clone();

                //改变克隆对象elements属性的指向
                another.elements = this.elements.clone();

                //重新开辟一块内存区域，改变克隆对象的指向
                another.buckets = new MyEntry[this.buckets.length];

                //向新开辟的区域装对象

                for(int i=0;i<this.size;i++) {
                    if (buckets[i] != null) {
                        //不能这么做，需要将每个bucket中元素 也重新复制一份新的
                        //another.buckets[i] = buckets[i];

                        another.buckets[i] = buckets[i].deepCopy();
                    }
                }
                return another;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }


        class MyEntry<T>{
            T data;
            MyEntry next;
            public MyEntry(T data, MyEntry next) {
                this.data = data;
                this.next = next;
            }
            //链表深拷贝的精髓
            //有个缺点，这种会是递归的模式去拷贝，容易造成栈递归层数过多而溢出

//            public MyEntry<T> deepCopy(){
//                return new MyEntry<>(data,next == null?null : next.deepCopy());
//            }

            public MyEntry<T> deepCopy(){
                MyEntry result = new MyEntry(data,next);
                MyEntry p = result.next;
                while(p!=null){
                    p = new MyEntry<>(p.data,p.next);
                    p = p.next;
                }
                return result;
            }
        }
    }




    private int pre;
    private double tail;


    /**
     *
     *
     * 对于 数值类型 避免使用 操作符<、>比较，应使用包装类的compare函数
     * @param o
     * @return
     */
    @Override
    public int compareTo(CloneableComparableObject o) {

        int res = Integer.compare(pre,o.pre);
        if(res ==0 ){
            return Double.compare(tail,o.tail);
        }
        return res;
    }
}

package lintcode;

import java.util.PriorityQueue;

/**
 * Created by unclexiao on 20/04/2018.
 */
public class MinStack {

    private final int DEFAULT_INIT_CAPACITY=10;
    private int[] elements;
    private int size;
    private int minElement;


    private PriorityQueue priorityQueue;

    public MinStack() {
        // do intialization if necessary
        this.elements = new int[DEFAULT_INIT_CAPACITY];
        this.size=0;
        this.minElement = Integer.MAX_VALUE;
        this.priorityQueue = new PriorityQueue();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        ensureCapacity();
        this.elements[this.size++] = number;

        if (number < this.minElement){
            this.minElement = number;
        }
        this.priorityQueue.add(number);

    }


    private void ensureCapacity(){
        if(size>=elements.length){
            //扩容
            int[] newElements = new int[elements.length*2+1];
            System.arraycopy(this.elements,0,newElements,0,size);
            this.elements = newElements;
        }
    }
    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(size<=0){
            throw  new IndexOutOfBoundsException("");
        }
        int v = this.elements[--this.size];

        this.priorityQueue.remove(v);
        //弹出的是最小的元素，需要重新
        if(v<=minElement){
            if(this.priorityQueue.isEmpty()){
                this.minElement = Integer.MAX_VALUE;
            }else {
                this.minElement = (int) this.priorityQueue.peek();
            }

        }
        return v;

    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return this.minElement;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.min();
        stack.push(1);
        stack.min();
    }
}

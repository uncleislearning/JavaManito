package servlet;

import java.util.Stack;

/**
 * Created by unclexiao on 14/04/2018.
 *
 * abcdefg          abcdefg
 *
 *
 *
 *
 */
public class StackQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
       stack1.push(node);
    }

    public int pop() {

        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        StackQueue sq = new StackQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        int item = sq.pop();
        System.out.println(item);
        sq.push(4);
        item = sq.pop();
        System.out.println(item);

    }
}

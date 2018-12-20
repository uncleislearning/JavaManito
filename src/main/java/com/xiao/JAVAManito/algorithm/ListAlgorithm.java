package com.xiao.JAVAManito.algorithm;


/**
 * Created by unclexiao on 17/03/2018.
 */
public class ListAlgorithm {


    /**
     * 定义单链表节点
     */
    private static class ListNode {
        public Object data;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(Object data) {
            this.data = data;
            this.next = null;
        }
    }


    /**
     * 遍历链表
     *
     * @param head
     */
    public static void traverseList(ListNode head) {
        if(head == null) return;

        ListNode p = head.next;
        while (p != null ) {
            System.out.println(p.data);
            p = p.next;
        }
    }


    /**
     * 带头节点的
     * @param datas
     * @return
     */
    public static ListNode createList(int[] datas) {
        if (datas.length <= 0) return null;

        ListNode head = new ListNode();
        ListNode rear = head;
        for (int i = 0; i < datas.length; i++) {
            ListNode newN = new ListNode(datas[i]);
            rear.next = newN;
            rear = newN;
        }
        return head;
    }


    /**
     * 反转单链表
     *
     * @param head
     * @return 新的头节点
     */

    public static ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode incur = head.next;

        ListNode pre = null;
        ListNode next = null;
        while (incur != null) {
            //保留链表的遍历的顺序
            next = incur.next;

            //将headnext指针往前指
            incur.next = pre;

            //调整pre的位置
            pre = incur;

            //调整head的位置
            incur = next;
        }

        head.next = pre;
        return head;
    }




    public static void main(String[] args) {

        //单链表的反转
//        int[] num = new int[]{1, 2, 3, 4, 5};
//        ListNode head = createList(num);
//
//        reverse(head);
//        traverseList(head);


        //双向链表的反转
//        int[] num = new int[]{1, 2, 3, 4, 5};
//        DoubleListNode head = createDoubleList(num);
//
//        System.out.println("********反转之前***********");
//        traverseDoubleList(head, true); //从头向后遍历
//
//        head = reverseDoubleList(head);
//
//        System.out.println("********反转之后***********");
//        traverseDoubleList(head, false);//从头向前遍历



        //判断是否有环

        int[] num = new int[]{1, 2,3,4,5};

        ListNode head = new ListNode();
        ListNode rear = head;
        for (int i = 0; i < num.length; i++) {
            ListNode newN = new ListNode(num[i]);
            rear.next = newN;
            rear = newN;
        }
        //rear.next = head.next.next.next;


        if(isLoop(head)){
            System.out.println("有环");
        }else {
            System.out.println("无环");
        }

    }



    public static boolean isLoop(ListNode head){

        //设置快慢指针，指向第一个节点
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast !=null && fast!=slow){
            //慢指针每次走一步
            slow = slow.next;

            //快指针每次走两步
            fast = fast.next;

            if(fast!=null){
                fast = fast.next;
            }

        }

        if(fast == null)
           return false;

        if(fast == slow)
            return true;

        return false;
    }

    public static DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode incur = head;
        DoubleListNode pre = null;
        DoubleListNode next;
        while (incur != null) {
            //保存前、后引用
            next = incur.next;

            //交换节点前后引用
            incur.pre = next;
            incur.next = pre;

            //调整遍历引用的位置
            pre = incur;
            incur = next;
        }

        return head;
    }

    /**
     * 遍历输出
     *
     * @param headOrRear
     * @param asc
     */

    public static void traverseDoubleList(DoubleListNode headOrRear, boolean asc) {

        if (asc) {
            while (headOrRear != null) {
                System.out.println(headOrRear.data);
                headOrRear = headOrRear.next;
            }
        } else {
            while (headOrRear != null) {
                System.out.println(headOrRear.data);
                headOrRear = headOrRear.pre;
            }
        }

    }


    public static DoubleListNode createDoubleList(int[] num) {

        if (num.length <= 0) return null;

        DoubleListNode head = new DoubleListNode(num[0]);

        DoubleListNode incur = head;

        DoubleListNode preN = null;

        for (int i = 1; i < num.length; i++) {
            DoubleListNode newNode = new DoubleListNode(num[i]);
            incur.next = newNode;
            newNode.pre = incur;
            preN = incur;
            incur = newNode;
        }
        return head;
    }


    //************双链表 反转

    private static class DoubleListNode {
        Object data;
        DoubleListNode pre;
        DoubleListNode next;

        public DoubleListNode() {
        }

        public DoubleListNode(Object data) {
            this.data = data;
            this.pre = null;
            this.next = null;
        }
    }


}

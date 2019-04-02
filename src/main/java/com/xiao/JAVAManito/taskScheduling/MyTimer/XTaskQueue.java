/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.taskScheduling.MyTimer;

import java.util.Comparator;

import java.util.PriorityQueue;

/**
 * 优先级队列，按照Task中nextExecutionTime从小到大排序
 *
 * @author xiaomengning
 * @version $Id: XTaskQueue.java, v 0.1 2019年03月28日 20:21 xiaomengning Exp $
 */
public class XTaskQueue {

    //任务比较定义
    private TaskComparator taskComparator = new TaskComparator();

    //优先级队列
    private PriorityQueue<XTimerTask> tasks = new PriorityQueue(taskComparator);

    /**
     * 将任务插入到合适的位置
     */
    public void add(XTimerTask timerTask) {
        tasks.add(timerTask);
    }

    /**
     * 移除队头任务
     *
     * @return
     */
    public XTimerTask removeMin() {
        return tasks.poll();
    }

    /**
     * 取出队头元素的引用
     *
     * @return
     */
    public XTimerTask getFirst() {
        return tasks.peek();
    }

    /**
     * 是否为空队列
     *
     * @return
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * 清空队列
     */
    public void clear() {
        tasks.clear();
    }


    /**
     * 清除已经取消的任务
     *
     * @return
     */
    public int purge() {
        int result;

        int before = tasks.size();

        tasks.removeIf(task -> task.getStatus() == XTimerTask.CANCELLED);

        int afterClean = tasks.size();

        result = before - afterClean;

        return result;
    }



    public int size(){
        return tasks.size();
    }

    private static class TaskComparator implements Comparator<XTimerTask> {

        @Override
        public int compare(XTimerTask o1, XTimerTask o2) {
            if (o1 == null || o2 == null) {
                throw new NullPointerException("other target can't be null");
            }

            if (o1.getNextExecutionTime() > o2.getNextExecutionTime()) {
                return 1;
            } else if (o1.getNextExecutionTime() == o2.getNextExecutionTime()) {
                return 0;
            } else {
                return -1;
            }
        }
    }

}
package com.xiao.JAVAManito.ForkJoin;


import java.util.concurrent.*;

/**
 * Created by unclexiao on 2017/11/22.
 * Fork Join java7引入的并行任务框架。
 * 可以将任务分割成足够小的小任务，然后让不同的线程来做这些分割出来的小事情，
 * 然后完成之后再进行join，将小任务的结果组装成大任务的结果。
 * 大任务拆分出来的小任务会被分发到不同的队列里面，每一个队列都会用一个线程来消费，
 * 这是为了获取任务时的多线程竞争，但是某些线程会提前消费完自己的队列。
 * 而有些线程没有及时消费完队列，这个时候，完成了任务的线程就会去窃取那些没有消费完成的线程的任务队列，为了减少线程竞争，
 * Fork/Join使用双端队列来存取小任务，分配给这个队列的线程会一直从头取得一个任务然后执行，
 * 而窃取线程总是从队列的尾端拉取task。
 *
 *
 * 下面是一个计算数组中最大数字的demo
 */
public class ForkJoinDemo {

    public static class MaxNumber extends RecursiveTask<Integer>{
        private int threshold = 2;

        private int[] array; // the data array

        private int index0 = 0;
        private int index1 = 0;
        public MaxNumber(int[] array, int index0, int index1) {
            this.array = array;
            this.index0 = index0;
            this.index1 = index1;
        }
        protected Integer compute() {
            int max = Integer.MIN_VALUE;
            //任务已经划分到设置的最新计算单元
            if((this.index1-this.index0)<=this.threshold){
                for(int i=this.index0;i<=this.index1;i++){
                        max=Math.max(max,this.array[i]);
                }
            }else {
                //将计算任务不断划分
                int mid = index0 + (index1 - index0) / 2;
                MaxNumber lMax = new MaxNumber(array, index0, mid);
                MaxNumber rMax = new MaxNumber(array, mid + 1, index1);

                lMax.fork();
                rMax.fork();

                int lm = lMax.join();
                int rm = rMax.join();
                 max = Math.max(lm,rm);
            }
            return max;
        }
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ForkJoinPool pool = new ForkJoinPool();
        int[] array = {100,400,200,90,80,300,600,10,20,-10,30,2000,1000};
        MaxNumber task = new MaxNumber(array, 0, array.length - 1);
        Future<Integer> future = pool.submit(task);

        System.out.println("Result:" + future.get(1, TimeUnit.SECONDS));


    }
}

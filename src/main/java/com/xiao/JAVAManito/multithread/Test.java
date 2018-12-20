package com.xiao.JAVAManito.multithread;



/**
 * Created by unclexiao on 31/01/2018.
 */
public class Test {



    public static class TaskRun{

        private  Integer number;

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer getNumber() {
            return number;
        }

        public void run() {
            for(int i=0;i<5;i++){
                synchronized (this){
                    this.number --;
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static class CountThread extends Thread{

        private boolean flag;
        private Integer number;
        private TaskRun taskRun;

        public CountThread(int number,TaskRun taskRun) {
            this.number = number;
            this.taskRun = taskRun;
            this.taskRun.setNumber(this.number);
        }

        @Override
        public void run() {
            while (!flag){
                this.taskRun.run();
                System.out.println("减5次");
//                new CountThread(this.taskRun.getNumber(),this.taskRun).start();
//                endThread();
            }
            System.out.println(Thread.currentThread().getName()+": stoped");
        }

       public void endThread(){
            this.flag = true;
       }
    }




    public static void main(String[] args) throws InterruptedException {
        TaskRun taskRun = new TaskRun();
        Integer integer = 100;
        CountThread countThread1 = new CountThread(integer,taskRun);
        CountThread countThread2 = new CountThread(integer,taskRun);

        countThread1.start();
        countThread2.start();

//        countThread1.endThread();
    }
}

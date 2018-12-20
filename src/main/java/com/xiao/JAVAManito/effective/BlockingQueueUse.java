package com.xiao.JAVAManito.effective;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.File;
import java.util.concurrent.Semaphore;

/**
 * Created by unclexiao on 06/06/2018.
 *
 * 使用 blockingqueue 实现生产者与消费者模式
 */
public class BlockingQueueUse {


    /**
     * 生产者
     */
    static class PageCrawl implements Runnable{

        private LinkedBlockingQueue queue;

        private String root;

        public PageCrawl(LinkedBlockingQueue queue,String root) {
            this.queue = queue;
            this.root = root;
        }

        @Override
        public void run() {
            try {
                doCrawl(this.root);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        public void doCrawl(String root) throws InterruptedException {
            File file = new File(root);
            if(file.isDirectory()){
                File[] fs = file.listFiles();
                for(File f: fs){
                    this.queue.put(f.getName());
                }
            }
        }
    }


    static class ConsumePage implements Runnable{
        private LinkedBlockingQueue<String> queue;

        public ConsumePage(LinkedBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while(true){
                try {
                    consume(this.queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        private void consume(String fileName){
            fileName+="test";
            System.out.println(fileName);
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(12);

        String[] files ={"a","b","c"};
        for(String file:files){
            new Thread(new PageCrawl(queue,file)).start();
        }
        int COMSUMEN = 5;
        for(int i=0;i<COMSUMEN;i++){
            new Thread(new ConsumePage(queue)).start();
        }

    }



}

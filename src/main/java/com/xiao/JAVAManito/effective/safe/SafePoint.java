package com.xiao.JAVAManito.effective.safe;

/**
 * Created by unclexiao on 19/05/2018.
 *
 * 线程安全且可变的对象
 *
 */
public class SafePoint {
    private int x,y;

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

   public synchronized int[] get(){
        return new int[]{x,y};
   }

   public synchronized void set(int x,int y){
       this.x = x;
       this.y = y;
   }
}

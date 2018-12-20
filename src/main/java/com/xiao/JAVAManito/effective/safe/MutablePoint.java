package com.xiao.JAVAManito.effective.safe;

/**
 * Created by unclexiao on 17/05/2018.
 *
 *可变对象，非线性安全
 */
public class MutablePoint {
    private int x;
    private int y;

    public MutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MutablePoint(MutablePoint point){
        this.x = point.getX();
        this.y = point.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

package com.xiao.JAVAManito.effective.safe;

/**
 * Created by unclexiao on 17/05/2018.
 *
 * 这是一个不可变的对象，线程安全
 */
public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

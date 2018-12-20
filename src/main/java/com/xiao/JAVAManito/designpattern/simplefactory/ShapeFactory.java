package com.xiao.JAVAManito.designpattern.simplefactory;

/**
 * Created by unclexiao on 2017/12/16.
 */
public class ShapeFactory {

    public static Shape getShape(String type){
        Shape shape = null;
        if(type.equals("circle")){
            shape = new CircleShape();
        }else if(type.equals("square")){
            shape = new SquareShape();
        }else {
            try {
                throw new UnSupportedShapeException();
            } catch (UnSupportedShapeException e) {
                System.out.println("不支持该类型");
                e.printStackTrace();
            }
        }
        return shape;
    }
}

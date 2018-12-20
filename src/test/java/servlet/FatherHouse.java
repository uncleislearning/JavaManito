package servlet;

/**
 * Created by unclexiao on 09/04/2018.
 *
 *
 * 1.父类无法访问子类中父类不具有的属性和方法
 * 2.子类能够对父类中同样的方法进行重写，并且父类调用该方法是可以调用到子类的实现的！
 * 3.子类与父类相同的属性，子类无法覆盖父类的属性，父类在调用时仍然拿到的是自己的值
 */
public class FatherHouse {

    protected double price;
    protected String location;
    //初始化之前，类加载的过程完成赋值


    public FatherHouse() {
        this.location = "R城";
    }


    public void sell(){
        System.out.println(".....");
    }
    public static void main(String[] args) {

        FatherHouse f = new House("p城");

        System.out.println(f.location); //子类的
        f.sell();
        //House h = new House();
        //向上转型
        //向下转型
    }
}

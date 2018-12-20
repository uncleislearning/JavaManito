package servlet;

/**
 * Created by unclexiao on 09/04/2018.
 */
public class House extends FatherHouse{
    protected String location;
    public int id;

    public House(String location) {
        this.location = location;
    }

    public void sell(){
        System.out.println("卖房子！");
    }
}

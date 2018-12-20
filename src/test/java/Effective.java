
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by unclexiao on 20/05/2018.
 */
public class Effective {

    @Test
    public void test1() {
        int res = Float.compare(0.12f, 0.34f);
        System.out.println(res);


        ArrayList<Double> a = new ArrayList<>();
        a.add(1.23);
        a.add(1.23);
        a.add(1.23);
        a.add(1.23);

        ArrayList<Double> b = new ArrayList<>();
        b.add(1.23);
        b.add(1.23);
        b.add(1.23);
        b.add(1.23);

        boolean res1 = Arrays.equals(a.toArray(), b.toArray());

        System.out.println(res1);


        Integer ac = null;
        Integer bd = 12;

        //System.out.println(Objects.equal(ac,bd));

        java.util.Objects.equals(ac, bd);
    }


}

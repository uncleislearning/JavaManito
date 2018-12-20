import org.junit.Test;

/**
 * Created by unclexiao on 15/05/2018.
 */
public class EffectiveJavaTest {

    public static class PrivateClass{

        private PrivateClass(){

        }

        public static PrivateClass getInstanceFromChild(){
            return new PrivateClassChild();
        }
    }


    private static class PrivateClassChild extends PrivateClass{

    }


    @Test
    public void test1(){
        PrivateClass pc = PrivateClass.getInstanceFromChild();
        System.out.println(pc);


        PrivateClassChild p = new PrivateClassChild();
        System.out.println(p);
    }
}

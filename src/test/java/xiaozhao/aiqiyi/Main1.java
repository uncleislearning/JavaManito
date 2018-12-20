package xiaozhao.aiqiyi;




import java.util.*;

/**
 * Created by unclexiao on 15/09/2018.
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int P = in.nextInt();

        List<Integer> food = new ArrayList<>();
        for(int i=1;i<=N;i++){
            food.add( in.nextInt());

        }


        for(int i=0;i<M;i++){
            String tag = in.next();
            int foodIndex = in.nextInt();
            int v = food.get(foodIndex-1);
            if(tag.equalsIgnoreCase("A")){
                food.set(foodIndex-1,++v);
            }else {
                food.set(foodIndex-1,--v);
            }
        }



        int rank = 0;

        for(int i=0;i<N;i++){
            if( i!=P &&  food.get(i)>food.get(P-1)){
                rank++;
            }
        }
        System.out.println(rank+1);
    }
}

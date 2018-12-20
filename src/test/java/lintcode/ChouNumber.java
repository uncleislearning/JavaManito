package lintcode;

/**
 * Created by unclexiao on 15/04/2018.
 */
public class ChouNumber {


    public int nthUglyNumber1(int n){
        int[] ugly = new int[n+2];
        ugly[0]=1;
        int num_2=0;
        int num_3=0;
        int num_5=0;

        //直接产生前n个丑数
        for(int i=1;i<=n;i++){
            //最小的那个
            ugly[i] = Math.min(Math.min(ugly[num_2]*2,ugly[num_3]*3),ugly[num_5]*5);

            //刚开始种子是1
            if(ugly[i] % 2 ==0){
                num_2++;
            }
            if(ugly[i] % 3 ==0){
                num_3++;
            }
            if(ugly[i] % 5 ==0){
                num_5++;
            }

        }

        return ugly[n-1];

    }

}

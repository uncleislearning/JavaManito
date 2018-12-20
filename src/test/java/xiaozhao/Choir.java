package xiaozhao;

import java.util.Scanner;

/**
 * Created by unclexiao on 25/04/2018.
 */
public class Choir {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int[] v = new int[n + 1];
        for (int i = 0; i < n; i++) {
            v[i] = console.nextInt();
        }
        int k = console.nextInt();
        int d = console.nextInt();

        choir(v, n, k, d);
    }
//    private static long max= Integer.MIN_VALUE;
//    private static void choir(int index,int count,long res,int n,int k,int d,int[] v,int last){
//        //表示已经遍历完毕或者已经选取了k个人
//        if(index>=n || count>=k){
//            if(res > max){
//                max = res;
//            }
//            return;
//        }
//
//        if(index-last<=d){
//            //才可加入
//            choir(index+1,count+1,res*v[index],n,k,d,v,index);
//
//        }
//
//        //不加入
//        choir(index+1,count,res,n,k,d,v,last);
//    }


    /**
     * 给定的数值 有正有负，而最终的结果又是乘积，对于遍历到某一个数值时，我们不能dp[i-1][j]>dp[i-1][j-1]*v[i-1]，因为v[i-1]有可能是负数，而dp[i-1][j-1]是正数，
     * 当v[i-1]为负数时，此时的局部最大应该是 最小的前i-1的子问题*v[i-1]
     *
     * @param v
     * @param n
     * @param k
     * @param d
     */
    private static void choir(int[] v, int n, int k, int d) {



        long[][] dpMax = new long[n + 1][k + 1]; //dp[i][j] 表示 从前i个人中(一定选择i) 剩余j个人可选，最大\小的结果    dpMax[1...n][k]最大值

        long[][] dpMin = new long[n + 1][k + 1];
        //初始化

        for (int j = 1; j <= k; j++) {
            dpMax[1][j] = v[0];
            dpMin[1][j] = v[0];
        }


        for(int i=1;i<=n;i++){
            dpMax[i][1]=v[i-1];
            dpMin[i][1]=v[i-1];
        }

        long MAX;
        long MIN;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {

                //if (i - last1 <= d) { //满足该条件
                // 选的情况下，找出局部的最大值 最小值
                 MAX = Long.MIN_VALUE;
                 MIN = Long.MAX_VALUE;
                for(int q=i-1;q>=1 && i-q<=d;q--){
                    long tmp =  Math.max(dpMax[q][j-1]*v[i - 1], dpMin[q][j-1]*v[i-1]);
                    if( tmp>MAX){
                        MAX = tmp;
                    }
                    tmp = Math.min(dpMax[q][j-1]*v[i - 1], dpMin[q][j-1]*v[i-1]);
                    if(tmp < MIN){
                        MIN = tmp;
                    }
                    dpMax[i][j] = MAX;
                    dpMin[i][j] = MIN;
                }
            }
        }

        MAX = Long.MIN_VALUE;
        for(int i=0;i<=n;i++){
            if(MAX < dpMax[i][k]){
                MAX = dpMax[i][k];
            }
        }
        System.out.println(MAX);
    }
}

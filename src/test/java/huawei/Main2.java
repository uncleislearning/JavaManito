package huawei;

import org.junit.Test;


import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by unclexiao on 02/03/2018.
 */
public class Main2 {

    public static int maxN = 4;//（1~10全排列）
    public static int[] p = new int[maxN+1]; //存放一个排列
    public static boolean[] exist = new boolean[maxN+1];
    public static void main(String[] args) {

        quanPai(1);

    }


    /**
     *
     * @param index 当前处理的p数组下标
     */
    public static void quanPai(int index){
        if(index == maxN+1){ //p中已经完成一次排序
            for(int i=1;i<=maxN;i++){
                System.out.print(p[i]+" ");
            }
            System.out.println();
            return;
        }

        //当前需要填入的是p的index位置，从1~maxN中选择一个没有放入p数组中的数填入
        for(int i=1;i<=maxN;i++){

            if(!exist[i]){ //说明数字i还没有放入数组p中
                p[index] = i;
                exist[i] = true;
                quanPai(index+1);

                exist[i] = false;
            }

        }


    }


    /**
     * 最长连续子序列的和
     * @param num
     * @param n
     */

    public static void LS(int[] num,int n){
        int [] dp = new int[n+1];//dp[i] 表示以i元素为首，到最后一个元素的最大连续值

        dp[n-1] = num[n-1];

        for(int i=n-2;i>=0;i--){
            dp[i]= Math.max(num[i],dp[i+1]+num[i]);
        }

        int k=dp[0];
        for(int i=0;i<n;i++){
            if(k<dp[i]){
                k = dp[i];
            }
        }
        System.out.println(k);

    }



    @Test
    public void test(){
        Object[] obj = new Object[3];
        obj[0]=1;
        obj[1] = 2;

        obj[2] = new Object[]{1,2,3,4,5};


       // System.out.println(obj);

        for(int i=0;i<3;i++){
            System.out.println(obj[i]);
        }
    }



}

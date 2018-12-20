package com.xiao.JAVAManito.algorithm;


/**
 * Created by unclexiao on 02/03/2018.
 */
public class DP {


    public static void main(String[] args) {

//        int[] w = new int[]{0,1,2,3,4,5,6,7,8,9,10};
//        int[] v = new int[]{0,1,5,8,9,10,17,17,20,24,30};
//
//        int n = 10;
//        int W = 4;
//
//        int maxV = backpackProblem2(w,v,n,W);
//        System.out.println(maxV);



//           DP d = new DP();
//        int[] nums = {10,1,11,2,12,3,11};
//        int res = d.longestIncreasingSubsequence(nums);
//        System.out.println(res);



        DP d = new DP();
        int res = d.longestCommonSubsequence("bedaacbade","dccaeedbeb");
        System.out.println(res);

    }


    /**
     * 记忆式递归，降低时间复杂度
     */
//
//    private static final int MAX=100;
//
//    public static int[] dp = new int[MAX]; //保存子问题的解
//
//    public static int f(int n){
////        if(n == 0 || n == 1 ) return 1;
////        else return f(n-1)+f(n-2);
//
//        if(n == 0 || n == 1 ) return 1;
//
//        if(dp[n]>0){  //结果已经有
//            return dp[n] ;
//        }else {
//            dp[n] = f(n - 1) + f(n - 2);
//            return dp[n];
//        }
//    }


    /**
     * 01背包问题 (每个物品不可重复买)
     * <p>
     * w[]      物品重量
     * v[]      物品价值
     * <p>
     * n  物品个数
     * W   背包容量
     */
    public static int backpackProblem(int[] w, int[] v, int n, int W) {

        //背包容量剩余j
        //dp[i][j] 表示1---i物品选择，物品最大价值  max(dp[i-1][j-w[i]]+v[i],dp[i-1][j])

        int[][] dp = new int[n + 1][W + 1];

        //初始化
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        //状态递推

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (j < w[i]) { //放不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-w[i]]+v[i],dp[i-1][j]);
                }
            }
        }

        return dp[n][W];
    }


    /**
     * 01背包问题 (每个物品可重复买)
     * <p>
     * w[]      物品重量
     * v[]      物品价值
     * <p>
     * n  物品个数
     * W   背包容量
     */
    public static int backpackProblem2(int[] w, int[] v, int n, int W) {

        //背包容量剩余j
        //dp[i][j] 表示1---i物品选择，物品最大价值  max(dp[i-1][j-w[i]]+v[i],dp[i-1][j])

        int[][] dp = new int[n + 1][W + 1];

        //初始化
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        //状态递推
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (j < w[i]) { //放不下
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j-w[i]]+v[i],dp[i-1][j]);//区别在这
                }
            }
        }

        return dp[n][W];
    }




    /**
     * 带条件的01背包问题
     *
     * @param w   物品重量
     * @param val 物品价值
     * @param q   物品是否是主件（条件）
     * @param n   物品数量
     * @param m   背包容量
     * @return
     */
    private static int zeroOnePackage(int[] w, int[] val, int[] q, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];//dp[i][j] 表示 1~i个物品中 j容量 最大价值

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (q[i] == 0) { //主件
                    if (w[i] <= j)
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + val[i]);
                } else { //附件
                    if (w[i] + w[q[i]] <= j)
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i] - w[q[i]]] + val[i] + val[q[i]]);
                }
            }
        }


        return dp[n][m];
    }


    /**
     * 使用DP解决最长递增子序列问题（LIS）
     * 一维DP问题
     */

    public int longestIncreasingSubsequence(int[] nums) {
        if(nums == null || nums.length<=0){
            return 0;
        }

        return maxDp(nums);
    }


    private int maxDp(int[] nums){

        //dp[i] 以 元素i结束的 最长子序列中的长度
        int[] dp = new int[nums.length+1];
        dp[0] = 1;

        for(int i=1;i<nums.length;i++){

            //从前往后依次比较，直到找到比自己小的并且是dp最大的那个队伍，插入最长子序列的队伍
            int max=Integer.MIN_VALUE+1; //记录最大的子序列长度
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[j]>max){
                    max = dp[j];
                }
            }

            //说明前面的都比自己大，自己值最长子序列的头一个
            if(max==Integer.MIN_VALUE+1){
                dp[i]=1;
            }else {
                dp[i] = max+1;
            }
        }

        //找出dp中最大的，即是 nums数组的最长子序列的长度

        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]>dp[max]){
                max=i;
            }
        }

        return dp[max];
    }


    /**
     * 最长公共子序列问题（LCS）
     * 二维DP问题
     * @param A
     * @param B
     * @return
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if("".equals(A)||"".equals(B)){
            return 0;
        }

        // 定义状态 ：dp[i][j] 表示 以A字符串i号位置结尾与以B字符串j号位置结尾的字符串的最大公共子序列长度
        int[][] dp = new int[A.length()+1][B.length()+1];

        //状态转移方程
        // dp[i][j] = dp[i-1][j-1]+1 A.charAt(i)==B.charAt(j)
        // dp[i][j] = max(dp[i-1][j],dp[i][j-1]) A.charAt(i)!=B.charAt(j)


        //初始化dp
        for(int i=0;i<A.length();i++) {
            if (A.charAt(i) == B.charAt(0)) {
                dp[i][0] = 1;
            } else {
                if(i==0){
                    continue;
                }
                dp[i][0] = dp[i - 1][0];
            }
        }
        for(int j=0;j<B.length();j++){
            if(B.charAt(j) == A.charAt(0)){
                dp[0][j]=1;
            }else {
                if(j==0){
                    continue;
                }
                dp[0][j] = dp[0][j-1];
            }
        }



        for(int i=1;i<A.length();i++){
            for(int j=1;j<B.length();j++){
                if(A.charAt(i) == B.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }



        return dp[A.length()-1][B.length()-1];
    }








}

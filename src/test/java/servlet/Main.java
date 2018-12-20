package servlet;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by unclexiao on 02/03/2018.
 */
public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);


        while (console.hasNext()) {

            int[] ans = new int[8];
            int n = Integer.parseInt(console.nextLine());

            for (int i = 0; i < n; i++) {
                String[] line = console.nextLine().split("~");
                String ip = line[0];
                String mask = line[1];

                if (isValideIP(ip)) {
                    ans[classifyIP(ip)]++;
                } else { //无效ip
                    ans[5]++;
                }

                if (!isValideMask(mask)) {
                    ans[5]++;
                }
            }
            for (int i = 0; i < ans.length - 1; i++) {
                System.out.print(ans[i] + " ");
            }


        }
    }

    private static boolean isValideMask(String mask) {

        if (!isValideIP(mask))
            return false;

        boolean[] flag = new boolean[256];
        flag[255] = true;
        flag[254] = true;
        flag[252] = true;
        flag[248] = true;
        flag[240] = true;
        flag[224] = true;
        flag[192] = true;
        flag[128] = true;
        flag[0] = true;

        String[] items = mask.split("\\.");


        int one = Integer.valueOf(items[0]);
        int two = Integer.valueOf(items[1]);
        int three = Integer.valueOf(items[2]);
        int four = Integer.valueOf(items[3]);


        return true;

    }

    private static boolean isValideIP(String ip) {
        String[] w = ip.split("\\.");

        if (w.length != 4) return false;

        for (int i = 0; i < w.length; i++) {

            if (w[i].equals("") || !w[i].matches("[0-9]*"))
                return false;

            int n = Integer.parseInt(w[i]);

            if (n > 255)
                return false;

        }
        return true;
    }


    private static int classifyIP(String ip) {
        String[] items = ip.split("\\.");


        int one = Integer.valueOf(items[0]);
        int two = Integer.valueOf(items[1]);


        if (one >= 1 && one <= 126) { //A类
            if (one == 10) {
                return 6;
            }
            return 0;
        } else if (one >= 128 && one <= 191) { //B类
            if (one == 172 && two >= 16 && two <= 31 || one == 192 && two == 168) {
                return 6;
            }
            return 1;
        } else if (one >= 192 && one <= 223) {
            return 2;
        } else if (one >= 224 && one <= 239) {
            return 3;
        } else if (one >= 240 && one <= 255) {
            return 4;
        }
        return 7;


    }


    /**
     * 带条件的01背包问题
     *
     * @param w   物品重量
     * @param val 物品价值
     * @param q   物品是否是主件
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


    @Test
    public void test() {

//        System.out.println("0123456789111423745353645.9".matches("[0-9]*"));

        int  a = 10>>1-1;
        System.out.println(a);
    }


    private final int id;

    {
        id=0;
    }

    public static  class Father {


    }

    class Mother{

    }

    class Child extends Father{
        Mo m = new Mo();
        class Mo extends Mother{

        }
    }

}

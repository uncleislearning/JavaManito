package com.xiao.JAVAManito.algorithm;

import java.util.LinkedList;

/**
 * Created by unclexiao on 01/04/2018.
 */
public class QuickSelect {


    public static void quickSelect(int[] data,int l, int r,int k,LinkedList<Integer>  res) {
        if (l > r) return;

        int pivot = l;
        int m = l; //表示基准最终在数组中的位置
        int temp;
        for (int i = l + 1; i <= r; i++) {
            //与基准比较啊！！！
            if (data[i] < data[pivot]) {
                //为了找基准最终的位置
                m++;

                //以基准为分界
                temp = data[m];
                data[m] = data[i];
                data[i] = temp;
            }
        }

        //将基准放到它该去的位置
        temp = data[pivot];
        data[pivot] = data[m];
        data[m] = temp;

        System.out.println(data[m]+"是第"+(data.length - m)+"大");

        if (data.length - m == k) {
            res.add(data[m]);
        } else if (data.length - m < k) {
             quickSelect(data,l, m-1,k,res);
        } else {
             quickSelect(data,m+1, r,k,res);
        }

    }


    public static void main(String[] args) {
        //快速选择算法，在O(N)时间内找出一个整数数组中第K大的数   平均复杂度为O(N)，最坏复杂度为O(N^2)

        int[] data = {-1, 100, 3, 8, 6};
        LinkedList<Integer> res = new LinkedList<>();
        quickSelect(data,  0, data.length - 1,3,res);

        System.out.println(res);
    }
}

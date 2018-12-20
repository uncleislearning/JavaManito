package com.xiao.JAVAManito.algorithm.sort;


import java.util.TreeMap;

/**
 * Created by unclexiao on 27/01/2018.
 */
public class AlgorithmMain {


    public static void main(String[] args) {

        //测试数据
        int[] array = new int[]{4, -1, 10, -8, 33};
//        int[] array = new int[]{-10, -1, 10, 18, 33};
//        int[] array = new int[]{10, 1, -10, -18, -33};
//        int[] array = new int[]{-10};


        //排序算法
//        bubbleSort(array);
//        selectionSort(array);
//        insertionSort(array);
//        shellSort(array);
//        mergeSort(array,new int[array.length],0,array.length-1);
//        quickSort(array,0,array.length-1);
//        quickSort2(array,0,array.length-1);


//        heapSort(array, true);
//        for (int item : array) {
//            System.out.println(item);
//        }


        int[] nums = new int[]{10,8,0,7,7,4,2,11,-9,-7,-9,-5};
        countSortT(nums);
    }


    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] array) {
        int len = array.length;

        //进行n轮
        for (int i = 0; i < len; i++) {
            //i轮进行n-i-1次比较
            for (int j = 1; j < len - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    /**
     * 选择排序
     */

    public static void selectionSort(int[] array) {
        int len = array.length;

        //进行n轮
        for (int i = 0; i < len; i++) {
            //保存最小值的下标,把最左边未排序第一个当做是最小值
            int minIndex = i;
            //比较，找最小值
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //交换
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

    }


    /***
     * 插入排序
     */


    public static void insertionSort(int[] array) {
        int len = array.length;

        //遍历无序数组部分
        for (int i = 1; i < len; i++) {
            //遍历有序数据部分，比较
            int j = i - 1;
            int target = array[i];
            for (; j >= 0 && array[j] > target; j--) {
                //如果有序元素大于无序元素，则向后移动一个位置
                array[j + 1] = array[j];
            }
            array[j + 1] = target;
        }
    }


    /**
     * 希尔排序
     */

    public static void shellSort(int[] array) {

        int len = array.length;
        int gap, temp;

        //缩放gap
        for (gap = len >> 1; gap > 0; gap >>= 1) {
            //遍历每个区
            for (int i = gap; i < len; i++) {
                //对每个区，进行插入排序
                temp = array[i];
                int j = i - gap;
                for (; j >= 0 && array[j] > temp; j -= gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;

            }
        }
    }


    /**
     * 递归版 归并排序
     *
     * @param array
     * @param result
     * @param start
     * @param end
     */
    public static void mergeSort(int[] array, int[] result, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = ((end - start - 1) >> 1) + start;
        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;

        mergeSort(array, result, start1, end1);
        mergeSort(array, result, start2, end2);

        int k = start;

        while (start1 <= end1 && start2 <= end2)
            result[k++] = array[start1] < array[start2] ? array[start1++] : array[start2++];

        while (start1 <= end1)
            result[k++] = array[start1++];

        while (start2 <= end2)
            result[k++] = array[start2++];

        System.arraycopy(result, start, array, start, end - start + 1);
    }


    /**
     * 快速排序，递归实现(单索引)，对于数组元素随机乱序 比较高效
     *
     * @param array
     */
    public static void quickSort(int[] array, int l, int r) {
        if (l >= r) return;

        //基准的当前的位置
        int m = l;

        for (int i = l + 1; i <= r; i++) {
            if (array[i] < array[l]) {
                m += 1;
                int temp = array[m];
                array[m] = array[i];
                array[i] = temp;
            }
        }

        int temp = array[m];
        array[m] = array[l];
        array[l] = temp;

        quickSort(array, l, m - 1);
        quickSort(array, m + 1, r);
    }

    /**
     * 快速排序，递归实现(双索引) 对于数组元素相等或者基本有序 比较高效
     */
    public static void quickSort2(int[] arrays, int l, int r) {
        if (l >= r) return;

        //定基准
        int pivot = arrays[l];

        int left = l + 1;
        int right = r;
        while (left <= right) {
            while (left <= right && arrays[left] < pivot) left++;
            while (left <= right && arrays[right] >= pivot) right--;

            if (left > right) break;

            int temp = arrays[left];
            arrays[left] = arrays[right];
            arrays[right] = temp;
        }

        int temp = arrays[right];
        arrays[right] = arrays[l];
        arrays[l] = temp;

        quickSort2(arrays, l, right - 1);
        quickSort2(arrays, right + 1, r);
    }


    /**
     * 堆排序（最大堆signal=-1、最小堆signal=1）
     */

    public static void heapSort(int[] array, boolean ascending) {
        if (ascending) {
            //建堆
            maxHeap(array, array.length);

            //排序
            for (int i = array.length - 1; i >= 0; i--) {
                //将最大的与数组最后一个进行交换
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                //重新建堆
                maxHeap(array, i);
            }

        } else {
            //建堆
            minHeap(array, array.length);
            //排序
            for (int i = array.length - 1; i >= 0; i--) {
                //将最小的与数组最后一个进行交换
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                //重新建堆
                minHeap(array, i);
            }

        }

    }


    /**
     * 建堆
     */
    private static void heapify(int[] array, int size, int sign) {
        //因为完全二叉树中节点i的左孩子2i、右孩子2i+1，而我们只需要对有孩子节点的进行向下调整
        for (int i = size / 2; i >= 0; i--) { //所以这里是前一般节点，需要进行向下调整
            shiftDown(array, i, size, sign);
        }
    }


    /**
     * 节点向下调整的过程：
     * 选择左右孩子最大的那个节点，与当前节点进行比较，如果是
     *
     * @param array
     * @param k
     * @param size
     * @param signal 1 小根堆、-1 大根堆
     */
    private static void shiftDown(int[] array, int k, int size, int signal) {
        int half = size >>> 1;
        while (k < half) {

            int index = k;

            int l = (k << 1) + 1; //左孩子
            if (l < size && (signal * array[l]) < (signal * array[index])) {
                index = l;
            }

            int r = l + 1;//右孩子
            if (r < size && (signal * array[r]) < (signal * array[index])) {
                index = r;
            }

            if (k == index) break; //说明不需要调整

            int temp = array[k];
            array[k] = array[index];
            array[index] = temp;


            k = index; //继续向下调整
        }
    }

    private static void minHeap(int[] array, int size) {
        heapify(array, size, 1);
    }

    private static void maxHeap(int[] array, int size) {
        heapify(array, size, -1);
    }


    /**
     * 计数排序
     * <p>
     * 适用于元素范围已知，且规模不大的排序，时间复杂度O(n)
     *
     * @param num
     */

    private static int MAX = 100;

    public static void countSort(int[] num) {

        int[] count = new int[MAX]; //计数数组

        for (int i = 0; i < num.length; i++) {
            count[num[i]]++;
        }

        for (int i=0;i<MAX;i++) {
            if(count[i]>0){
                for(int j=0;j<count[i];j++){
                    System.out.println(i);
                }
            }
        }
    }




    //那么对于不规格数字怎么办（比如包含负数-1）处理的数字范围-100~100


    public static void countSortT(int[] num) {

        int[] countP = new int[MAX+1]; //计正数数组
        int[] countN = new int[MAX+1];//计负数数组

        for (int i = 0; i < num.length; i++) {
            if(num[i]>=0)
                countP[num[i]]++;
            else
                countN[Math.abs(num[i])]++;
        }

        for (int i=MAX;i>0;i--) {
            if(countN[i]>0){
                for(int j=0;j<countN[i];j++){
                    System.out.println(i-2*i);
                }
            }
        }

        for (int i=0;i<MAX;i++) {
            if(countP[i]>0){
                for(int j=0;j<countP[i];j++){
                    System.out.println(i);
                }
            }
        }
    }


}

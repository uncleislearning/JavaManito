package tooffer;

import com.google.common.primitives.Ints;

import java.io.Serializable;
import java.util.*;

/**
 * Created by unclexiao on 15/04/2018.
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {
        MinNumberInRotateArray m = new MinNumberInRotateArray();
        int[] array = {3,4,5,1,2};
        int min = m.minNumberInRotateArray(array);
        System.out.println(min);

    }

    public int minNumberInRotateArray(int [] array) {
        if(array.length <= 0){
            return 0;
        }

        sort(array);

        return array[0];
    }

    public void sort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int l,int r){
        if(l>=r)
            return;

        int m = l;
        int tmp;

        for(int i=l+1;i<=r;i++){
            if(nums[i] < nums[l]){
                m++;
                tmp = nums[i];
                nums[i] = nums[m];
                nums[m] = tmp;
            }
        }

        tmp = nums[m];
        nums[m] = nums[l];
        nums[l] = tmp;

        quickSort(nums,l,m-1);
        quickSort(nums,m+1,r);

    }


//    public static List<Integer> asList(int... backingArray) {
//        return (List)(backingArray.length == 0?Collections.emptyList():new IntArrayAsList(backingArray));
//    }
//
//
//    private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess,Serializable{
//
//        private int[] array;
//        private int start;
//        private int end;
//
//
//        private static final long serialVersionUID = 0L;
//
//        public IntArrayAsList(int[] array) {
//            this(array,0,array.length);
//
//        }
//
//        public IntArrayAsList(int[] array, int start, int end) {
//            this.array = array;
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        public Integer get(int index) {
//            if(index < 0 || index>=size())
//                throw new IndexOutOfBoundsException("数组下标越界");
//
//            return Integer.valueOf(this.array[this.start+index]);
//        }
//
//        @Override
//        public int size() {
//            if(start>=end)
//                throw new IndexOutOfBoundsException("数组起始下标不正确");
//
//
//            return end-start;
//        }
//    }


}

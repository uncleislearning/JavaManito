package lintcode;

/**
 * Created by unclexiao on 14/04/2018.
 */
public class Kth {


    public static void main(String[] args) {
        Kth kth = new Kth();
        int[] nums = {1,5,2,6,5};
        int res = kth.kthLargestElement(5,nums);
        System.out.println(res);
    }

    public int kthLargestElement(int k, int[] nums) {

       return quickSort(nums,k,0,nums.length-1);
    }



    public int quickSort(int[] nums,int k,int l,int r){

        int m = l; //指向最后一个不大于 基准元素的位置
        int tmp;

        for(int i=l+1;i<=r;i++){
            //遇到比基准元素小的，这个时候需要将它与 比基准元素大的位置进行交互，那比基准元素大的位置在哪呢？m+1
            if(nums[i]<nums[l]){
                m++; //先++,就是最先碰到的比基准元素大的

                tmp = nums[i];
                nums[i] = nums[m];
                nums[m] =tmp;
            }
        }


        tmp = nums[m];
        nums[m] = nums[l];
        nums[l] = tmp;

        //m 是第几大？？   比m小的有m个    那么比m大的有多少个
        if(nums.length-m == k){
            return nums[m];
        }else if(nums.length-m < k ){
            return quickSort(nums,k,l,m-1);
        }else {
            return quickSort(nums,k,m+1,r);
        }



    }
}

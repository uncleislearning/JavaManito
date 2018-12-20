package tooffer;

/**
 * Created by unclexiao on 16/04/2018.
 */
public class JumpFloor {

    /**
     *  Target 个台阶，每次可以跳 1阶 或者 2阶，求总共有多少种跳法
     * @param target
     * @return
     */

    public static void main(String[] args) {
        JumpFloor j = new JumpFloor();
        int res = j.jumpFloor(3);
        System.out.println(res);

    }

    public int jumpFloor(int target) {

        return jumpFloorII(0,target);
    }


    private int jumpFloor(int sum,int target){
        if(sum>=target){
            //一种跳法
            return 1;
        }
        //可以跳2阶
        int a=0,b=0;
        if(target-sum>=2){
            a = jumpFloor(sum+2,target);
        }

        if(target-sum>=1){
            b = jumpFloor(sum+1,target);
        }

        return a+b;


    }

    private int jumpFloorII(int sum,int target){
        if(sum>=target){
            //一种跳法
            return 1;
        }
        //可以跳2阶
        int count=0;

        for(int i=1;i<=target;i++){
            if(target-sum>=i){
                count+=jumpFloorII(sum+i,target);
            }
        }
        return count;


    }
}

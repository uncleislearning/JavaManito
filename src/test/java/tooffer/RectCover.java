package tooffer;

/**
 * Created by unclexiao on 19/04/2018.
 */
public class RectCover {

    public int rectCover(int target) {
        if(target<=0){
            return 0;
        }

        if(target ==1){
            return 1;
        }

        if(target ==2){
            return 2;
        }

        int[] f = new int[target+1];
        f[1]=1;
        f[2]=2;

        for (int i=3;i<=target;i++){
            f[i] = f[i-2]+f[i-1];
        }

        return  f[target];
    }



}

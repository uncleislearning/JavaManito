package lintcode;

/**
 * Created by unclexiao on 13/04/2018.
 */
public class DigitCounts {

    public int digitCounts(int k, int n) {
        // write your code here

        int count = 0;
        int tmp;
        for (int i = 0; i <= n; i++) {
            if ((tmp = numberContain(k, i)) > 0) {
                count += tmp;
            }
        }
        return count;
    }

    //判断 数字 num中是否包含 k 0~9
    private int numberContain(int k, int num) {
        int r;
        int count = 0;
        do {
            r = num % 10;
            if (r == k) {
                count++;
            }
            num = num / 10;
        } while (num != 0);

        return count;
    }

}

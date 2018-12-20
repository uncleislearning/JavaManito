package tooffer;

import org.junit.Test;

/**
 * Created by unclexiao on 20/04/2018.
 */
public class NumberOf1 {


    /**
     * 求给定整数二进制补码中 1的个数
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        //逐个位测试 利用 0x00000001 & n   n为32位

        int mask = 0x00000001;
        int count = 0;
        for (int i = 0; i < 32; i++) {

            if ((mask & n>>>i) == 1) {
                count++;
            }

        }

        return count;
    }


    @Test
    public void test1() {
        int mask = 0x00000001;
        int n = 1;

        int res = NumberOf1(n);
        System.out.println(res);
//        System.out.println(mask & n);
//        System.out.println(mask & n >>> 1);
//        System.out.println(mask & n >>> 2);
//        System.out.println(mask & n >>> 3);
//        System.out.println(mask & n >>> 4);
    }
}

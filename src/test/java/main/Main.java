package main;

import org.junit.Test;

import java.util.*;

/**
 * Created by unclexiao on 27/03/2018.
 */
public class Main {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int w = in.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = in.nextInt();
            }

            three(0, 0, v, w, n);
            System.out.println(count);

            count=0;
        }
    }

    public static int count = 0;

    public static void three(int index, int sumV, int[] v, int w, int n) {
        if (index >= n) {
            if (sumV <= w) {
                count++;
                return;
            }
        }

        //当前在index

        if (v[index] + sumV <= w) { //才能放
            three(index + 1, v[index] + sumV, v, w, n);
        }

        //不放
        three(index + 1, sumV, v, w, n);
    }

    public static void two(Scanner in) {
        int n = in.nextInt();
        int k = in.nextInt();

        int count = 0;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (x % y >= k) {
                    count++;
                }
            }
        }

        System.out.println(count);



    }



    @Test
    public void testList(){
        LinkedList<Integer> row = new LinkedList<>();
        row.add(5);
        row.add(1);
        row.add(3);

        row.add(-1);
        row.add(-9);




    }


}

package huawei;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();


            int[] nums = new int[1000001];
            boolean[] flags = new boolean[1000000];
            int si = 0;
            for (int i = 0; i < n; i++) {
                int temp = in.nextInt();
                if (!flags[temp]) {
                    nums[si++] = temp;
                    flags[temp] = true;
                }
            }
            int count = 0;

            if (si == 1 && k == 0) {
                count = 1;
            } else {

               quickSort(nums,0,si-1);

                for (int i = 0,j=i+1; i < j; ) {
                    if (nums[j] - nums[i]== k) {
                        count++;
                        i++;
                        j++;
                        if(j == si){
                            break;
                        }
                    } else if (nums[j]- nums[i] > k) {
                        i++;
                        if(j==i){
                            j++;
                            if(j == si){
                                break;
                            }
                        }
                    } else {
                        j++;
                        if(j == si){
                            break;
                        }
                    }
                }
            }

            System.out.println(count);

        }

    }



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



    public static void wangyi2018two(Scanner in) {
        int num = in.nextInt();
        List<Integer> rev = new ArrayList<>(); //5321
        int substitute = num;
        int r;//尾数
        while (substitute != 0) {
            r = substitute % 10;
            rev.add(r);
            substitute = substitute / 10;
        }

        int reverge = 0;
        for (int i = 0; i < rev.size(); i++) {
            reverge = reverge * 10 + rev.get(i);
        }

        System.out.println(reverge + num);
    }

    public static void wangyi2018one(Scanner in) {
        Stack<Integer> res = new Stack<>();
        int target = in.nextInt();

        while (target > 0) {
            if (target % 2 == 0) {
                res.push(2);
                target = (target >> 1) - 1;
            } else {
                res.push(1);
                target = (target - 1) / 2;
            }
        }
        while (!res.isEmpty()) {
            System.out.print(res.pop());
        }
    }


    public static void wangyi2018three(Scanner in) {
        int count = 0;
        char[] str = in.nextLine().toCharArray();
        int len = str.length;
        char last = str[0];
        for (int i = 1; i < len; i++) {

            if (last != str[i]) {
                count++;
            }

            last = str[i];
        }

        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println((df.format(len * 1.0 / (count + 1))));
    }


    @Test
    public void test() {
        Map<Integer, Integer> s = new HashMap();
        for (Map.Entry<Integer, Integer> i : s.entrySet()) {
            System.out.println("llll");
        }
    }
}
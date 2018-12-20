package xiaozhao.toutiao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by unclexiao on 25/08/2018.
 */
public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[][] friendship = new boolean[n + 10][n + 10];

        for (int i = 1; i <= n; i++) {
            int index = in.nextInt();
            while (index!=0){
                friendship[i][index] = true;
                friendship[index][i] = true;
                index = in.nextInt();
            }
        }


        //分组
        int m = 0;
        boolean[] flag = new boolean[n + 10];

        for (int i = 1; i <= n; i++) {
            //当前这个人没有加入一个group
            if (!flag[i]) {
                //更新flag ,广度优先遍历
                m++;
                flag[i] = true;
                LinkedList<Integer> queue = new LinkedList();
                queue.addFirst(i);
                while (!queue.isEmpty()) {
                    int head = queue.removeFirst();

                    //do nothing

                    //将head的朋友入队
                    for (int j = 1; j <= n; j++) {
                        if (!flag[j] & friendship[head][j]) {
                            queue.add(j);
                            flag[j] = true;
                        }
                    }
                }

                //这个group 就加完了
            }
        }
        System.out.println(m);
    }

}

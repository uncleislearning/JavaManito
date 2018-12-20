package xiaozhao.aiqiyi;

import java.util.Scanner;

/**
 * Created by unclexiao on 15/09/2018.
 */
public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String line = in.nextLine();

        String onePart = line.substring(0,3);
        String anoPart = line.substring(3);

        int maxA = Integer.MIN_VALUE+1;
        int minA = Integer.MIN_VALUE-1;
        int sumA = 0;
        for(char a : onePart.toCharArray()){
            int temp = (a - '0');
            sumA += temp;
            if(temp < minA){
                minA = temp;
            }
            if(temp > maxA){
                maxA = temp;
            }
        }

        int maxB = Integer.MIN_VALUE+1;
        int minB = Integer.MIN_VALUE-1;
        int sumB = 0;
        for(char b : anoPart.toCharArray()){
            int temp = (b - '0');
            sumB += temp;
            if(temp < minB){
                minB = temp;
            }
            if(temp > maxB){
                maxB = temp;
            }
        }

        if(sumA == sumB){
            System.out.println(0);
            return;
        }



        int diff = Math.abs(sumA-sumB);
        if(diff<=9){

            if(maxA>=diff || maxB>=diff || Math.abs(9-minA)>=diff || Math.abs(9-minB)>=diff ){
                System.out.println(1);
            }else {
                System.out.println(2);
            }

        }else if(diff<=18){

            System.out.println(2);

        }else {
            System.out.println(3);
        }

    }
}

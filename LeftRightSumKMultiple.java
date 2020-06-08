package CodeSnippets;

import java.util.Scanner;

public class LeftRightSumKMultiple {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            totalSum += a[i];
        }

        int count = 0;
        int leftSum = a[0];
        int rightSum = totalSum - a[0];
        int i = 0;
        while(i < n){
            if(Math.abs(leftSum - rightSum) % k == 0){
                System.out.print(i + " ");
                count++;
            }
            i++;
            if(i < n) {
                leftSum += a[i];
                rightSum -= a[i];
            }
        }
        System.out.println("Count: " + count);
        sc.close();
    }

}
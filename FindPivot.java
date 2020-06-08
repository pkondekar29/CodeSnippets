package CodeSnippets;

import java.util.Scanner;

public class FindPivot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += a[i];
        }

        int leftSum = 0;
        for(int i = 0; i < n; i++){
            if(i != 0) leftSum += a[i - 1];
            if(totalSum - leftSum - a[i] == leftSum){
                System.out.println(i);
            }
        }

        /*** Space complexity is O(n) */
        // int[] sumArr = new int[n];
        // sumArr[0] = a[0];

        // for(int i = 1; i < n; i++){
        //     sumArr[i] = sumArr[i - 1] + a[i];
        // }
        // new HeapSort().printArray(a);
        // new HeapSort().printArray(sumArr);

        // int i = 1;
        // boolean found = false;
        // while(i < n && !found) {
        //     if(sumArr[i - 1] == (sumArr[n - 1] - sumArr[i])) {
        //         found = true;
        //     }
        //     i++;
        // }

        // if(sumArr[n - 1] - sumArr[0] == 0){
        //     System.out.println(0);
        // } else {
        //     if(found) {
        //         System.out.println(i - 1);
        //     } else {
        //         System.out.println(-1);
        //     }
        // }
    }

}
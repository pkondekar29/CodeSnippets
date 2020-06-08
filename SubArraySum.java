package CodeSnippets;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubArraySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        int i = 0;
        int currSum = 0;
        boolean found = false;
        int count = 0;
        int p = 0, q = 0;
        Map<Integer, Integer> prevSum = new HashMap<>();
        while(i < n && !found) {
            currSum += a[i];

            if(a[i] == sum) {
                count++;
                found = true;
                p = 1;
                q = i + 1;
            }

            if(prevSum.containsKey(currSum - sum)) {
                count += prevSum.get(currSum - sum);
                // What is p & q
            }
            Integer c = prevSum.get(currSum - sum);
            if(c == null) {
                prevSum.put(currSum, 1);
            } else {
                prevSum.put(currSum, c + 1);
            }

            
        }


        if(found) {
            System.out.println("Count: " + count);
            System.out.println(p + " " + q);
        } else {
            System.out.println("-1");
        }
        sc.close();

        /**  O(n^2) solution  */
        // int[] sumArr = new int[n];
        // sumArr[0] = a[0];
        // for(int i = 1; i < n; i++){
        //     sumArr[i] = sumArr[i - 1] + a[i];
        // }

        // boolean found = false;
        // int i = 0;
        // int j = 0;

        // for(; i < n - 1 && !found; i++){
        //     for(j = i + 1; j < n; j++){
        //         if(sumArr[j] == sum) {
        //             found = true;
        //             System.out.println("1 " + (j + 1));
        //         } else if(sumArr[j] - sumArr[i] == sum) {
        //             found = true;
        //             System.out.println((i + 2) + " " + (j + 1));
        //         }
        //     }
        // }
        // if(!found)
        //     System.out.println("-1");
    }

}
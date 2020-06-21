package CodeSnippets;

import java.util.Scanner;

public class RearrangeArrayAlternatively {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        /** Simple approach os to take O(n) array and fill the array with high/low elements at odd/even places */

        /** The other approach tries to store 2 numbers at a position using modulo & division */
        /**
         * The below is incorrect
         */
        // int i = 0, tempin = a[0], tempout = a[0];
        // int loc = 0;
        // for(int step = 0; step < n; step++) {
        //     if(i >= n/2) {
        //         loc = 2 * (n - i - 1);
        //     } else {
        //         loc = 2 * (i + 1) - 1;
        //     }
        //     tempin = tempout;
        //     tempout = a[loc];
        //     a[loc] = tempin;
        //     i = loc;
        // }
        sc.close();
        new HeapSort().printArray(a);
    }

}
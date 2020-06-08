package CodeSnippets;

import java.util.Scanner;

public class RotateByK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        rotateByK(a, n, k);
        new HeapSort().printArray(a);
    }

    public static void rotateByK(int[] a, int n, int k){
        int t1, t2;
        k = k % n;
        for(int i = 0; i < k; i++){     // For each element in k iterations
            t1 = a[i];
            int j = (i + k) % n;
            while(j < n){
                t2 = a[j];
                a[j] = t1;
                t1 = t2;
                j = j + k;
            }
            a[i] = t1;
        }
    }

}
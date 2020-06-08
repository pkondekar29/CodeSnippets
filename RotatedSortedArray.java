package CodeSnippets;

import java.util.Scanner;

@Deprecated
public class RotatedSortedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        sc.close();
        new RotatedSortedArray().search(num, a);
    }

    public void search(int n, int[] a){
        int l = 0, h = a.length;
        int m;
        boolean found = false;
        while(l < h && !found){
            m = (l + h) / 2;
            if(a[m] == n) { // the element matches
                System.out.println(m);
                found = true;
                // There can be only 2 scenarios 
                // 1. Rotation point
            } else if(a[m - 1] < a[m] && a[m] < a[m + 1]){      
                if(n < a[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // 2. Normal point where left is smaller and right is greater
                if(n < a[m] && n > a[l]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
    }

}
package CodeSnippets;

/*package whatever //do not write package name here */

import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
		    arr[i] = sc.nextInt();
		}
        int sum = sc.nextInt();
        sc.close();
		int j = findPivot(arr);
		int i = (j + 1) % arr.length;
        boolean isPresent = isSumPresent(arr, sum, i, j);
        System.out.println(isPresent == true ? "found" : "not found");
	}
	
	private static boolean isSumPresent(int[] a, int sum, int i, int j){
        int s;
        while(i != j) {
            s = a[i] + a[j];
            if(s == sum) {
                return true;
            } else if(s > sum) {
                j--;
                if(j < 0){
                    j = a.length - 1;
                }
            } else {
                i = (i + 1) % a.length;
            }
        }
        return false;
	}
	
	private static int findPivot(int[] arr){
	    return bSearch(arr, 0, arr.length - 1);
	}
	
	private static int bSearch(int[] a, int low, int high){
        int mid = (low + high) / 2;
        if(mid == 0 || mid == a.length - 1){        // this case will come only when the array is sorted 
            return a.length - 1;
        }
	    if(a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) { // highest number
	        return mid;
	    } else if(a[mid] < a[low] && a[mid] < a[high]) {
	        return bSearch(a, low, mid - 1);
	    } else {
	        return bSearch(a, mid + 1, high);
	    }
	}
}
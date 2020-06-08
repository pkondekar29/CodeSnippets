package CodeSnippets;

import java.util.Scanner;

public class SecondLargestNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n;
        SecondLargestNumber g = new SecondLargestNumber();
		n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		//int elem = g.bubbleSort(a, 2);
		int elemHeap = g.kSort(a, 2);
		//System.out.println(elem);
        
        sc.close();
    }
    
	private int kSort(int[] a, int k) {
		HeapSort h = new HeapSort();
		for(int i = 0; i < k; i++){
			h.maxHeapify(a, a.length, i);
		}
		h.printArray(a);
		return a[k];
	}

	public int bubbleSort(int[] a, int k) {
	    int t;
	    for(int i = 0; i < k; i++){
	        for(int j = 0; j < a.length - i - 1; j++){
	            
	            if(a[j] < a[j + 1]){
	                t = a[j];
	                a[j] = a[j + 1];
	                a[j + 1] = t;
	            }
	            
	        }
	        
		}
		new HeapSort().printArray(a);
	    return a[a.length - 2];
	    
	}

}
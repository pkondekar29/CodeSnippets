package CodeSnippets;

import java.util.Scanner;

public class MoveZerosToRight {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] a = new int[n];
	    for(int i = 0; i < n; i++){
		    a[i] = sc.nextInt();
	    }
	    
	    partition(a);
    }

    public static void partition(int[] a){
	    int i = 0;
	    int temp;
	    int size = a.length - 1;
		for(int j = 0; j < size && i < size; j++){
		    if(a[j] != 0){
			    i++;
			    while(a[i] != 0){
				    i++;
			    }
			    
			    if(i < size){
			    	temp = a[i];
			    	a[i] = a[j];
			    	a[j] = a[i];
			    }
		    }
	    }
    }
				   
	    
}

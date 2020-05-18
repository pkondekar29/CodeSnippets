#include<stdio.h>

/*Fuction to get gcd of a and b*/
int gcd(int a, int b) 
{ 
    if (b == 0) 
        return a; 
    else
        return gcd(b, a % b); 
} 

void rotateLeftByK(int arr[], int n, int d){
	int i, j, k, temp; 
    int g_c_d = gcd(n, d); 
    for (i = 0; i < g_c_d; i++) { 
    	j = i;
    	temp = arr[i];
    	while(1){
    		k = j + d;
    		if(k >= n)
    			k = k - n;
			if(k == i)
				break;
			arr[j] = arr[k];
			printf("move from %d to %d\n", k, j);
			j = k;
		}
		arr[j] = temp;
		printf("move from %d to %d\n", i, j);
    } 
}

void printArray(int a[], int n){
	int i;
	for(i = 0; i < n; i++){
		printf("%d ", a[i]);
	}
	printf("\n");
}

int main(){
	int i, n, k;
	scanf("%d %d", &n, &k);
	int a[n];
	for(i = 0; i < n; i++){
	//	scanf("%d", &a[i]);
		a[i] = i + 1;
	}
	
	rotateLeftByK(a, n, k);
	printArray(a, n);
	return 0;
}

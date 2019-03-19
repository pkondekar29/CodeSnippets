/*
 * =====================================================================================
 *
 *       Filename:  kSmallestNearX.c
 *
 *    Description:  K smallest elements near X on wither side
 *
 *        Version:  1.0
 *        Created:  Sunday 10 March 2019 07:40:40  IST
 *       Revision:  none
 *       Compiler:  gcc
 *
 * =====================================================================================
 */
#include <stdlib.h>
#include <stdio.h>
int findX(int a[], int n, int x){
	int low = 0, high = n - 1;
	int mid;
	while(low < high){
		mid = (low + high)/2;
		if(a[mid] == x){
			return mid;
		} else if(a[mid] > x){
			high = mid - 1;
		} else {
			low = mid + 1;
		}
	}
}

void print(int a[], int start, int end, int dontPrint){
	for(int i = start; i <= end; i++){
		if(i != dontPrint){
			printf("%d ", a[i]);
		}
	}
	printf("\n");
}

int main(){
	int k, n, x, t;
	scanf("%d", &t);
	while(t--){
		scanf("%d", &n);
		int a[n];
		for(int i = 0; i < n; i++){
			scanf("%d", &a[i]);
		}
		scanf("%d %d", &k, &x);
		int pos = findX(a, n, x);
		if((pos + (k/2)) > n - 1){
			print(a, n - k - 1, n - 1, pos);
		} else if(pos - (k/2) < 0){
			print(a, 0, k, pos);
		} else{
			print(a, pos - (k/2), pos + (k/2), pos);
		}
	}
	return 0;
}

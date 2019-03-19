/*
 * =====================================================================================
 *
 *       Filename:  count1s.c
 *
 *    Description:  Counts 1s in sorted array
 *
 *        Version:  1.0
 *        Created:  Tuesday 19 March 2019 08:22:06  IST
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdlib.h>
#include<stdio.h>

int find1(int *a, int low, int high){
	if(low > high){
		return -1;
	}
	int mid = (low+high)/2;
	if( a[mid] == 1 && a[mid + 1] == 0){
		return mid;
	} else if(a[mid] == 1){
		return find1(a, mid + 1, high);
	} else{
		return find1(a, low, mid - 1);
	}
}

int find1s(int a[], int n){
	return find1(a, 0, n-1);
}

int main(){
	int t, n;
	scanf("%d", &t);
	while(t--){
		scanf("%d", &n);
		int a[n];
		for(int i = 0; i < n; i++){
			scanf("%d", &a[i]);
		}

		printf("%d\n", find1s(a, n));
	}
}


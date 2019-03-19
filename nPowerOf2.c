/*
 * =====================================================================================
 *
 *       Filename:  nPowerOf2.c
 *
 *    Description:  Find if number N is power of 2
 *
 *        Version:  1.0
 *        Created:  Sunday 10 March 2019 08:15:35  IST
 *       Revision:  none
 *       Compiler:  gcc
 *
 * =====================================================================================
 */
#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>
#define MAX_SIZE 61

void initialiseArr(int a[]){
	for(int i = 0; i < MAX_SIZE; i++){
		a[i] = 0;
	}
}

int convertNumberToBinary(int a[], int n){
	int i = 0;
	while(n > 0){
		a[i] = n%2;
		printf("%d\n", n);
		n = n/2;
		i++;
	}
	return i;
}

bool isPowerOf2(int a[]){
	int numberOfOccurences = 0;
	for(int i = 0; i < MAX_SIZE; i++){
		if(a[i] == 1){
			numberOfOccurences++;
		}
	}
	return (numberOfOccurences == 1);
}

int main(){
	int t;
	int n;
	scanf("%d", &t);
	int a[MAX_SIZE];
	while(t--){
		scanf("%d", &n);
		initialiseArr(a);
		convertNumberToBinary(a, n);
		if(isPowerOf2(a)){
			printf("YES\n");
		} else{
			printf("NO\n");
		}
	}
	return 0;
}

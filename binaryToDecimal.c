#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>
#define MAX_SIZE 16

void initialiseArr(int a[]){
	for(int i = 0; i < MAX_SIZE; i++){
		a[i] = 0;
	}
}

int convertNumberToBinary(int a[], unsigned long n){
	int i = 0;
	while(n > 0){
		a[i] = n%2;
		n = n/2;
		i++;
	}
	return i;
}

void printBinaryNumber(int a[], int max){
    for(int i = max; i >= 0; i--){
        printf("%d", a[i]);
    }
    printf("\n");
}

int main(){
	int t;
	unsigned long n;
	scanf("%d", &t);
	int a[MAX_SIZE];
	while(t--){
		scanf("%lu", &n);
		initialiseArr(a);
		printBinaryNumber(a, convertNumberToBinary(a, n));
	}
	return 0;
}

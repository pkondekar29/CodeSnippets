#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

void printPartialArray(int a[], int start, int end){
	for(int i = start; i < end; i++){
		printf("%d ", a[i]);
	}
	printf("\n");
}

void merge(int a[], int l, int m, int n){
	int b[n-l];
	int i = l, j = m, k = 0;
	while(i < m && j < n){
		if(a[i] > a[j]){
			b[k] = a[j];
			j++;
			k++;
		} else{
			b[k] = a[i];
			i++;
			k++;
		}
	}
	while(i < m){
		b[k] = a[i];
		i++; 
		k++;
	}
	while(j < n){
		b[k] = a[j];
		j++;
		k++;
	}

	for(int i = l; i < (n - l); i++){
		a[i] = b[i];
	}
	printPartialArray(a, l, n);
}
	

void mergeSort(int a[], int low, int high){
	int mid = (low + high)/2;

	if(low < high){
		mergeSort(a, low, mid);
		mergeSort(a, mid+1, high);
		merge(a, low, mid, high);
	}
}

int main(){
	int n;
	scanf("%d", &n);
	int a[n];
	for(int i = 0; i < n; i++){
		scanf("%d", &a[i]);
	}
	mergeSort(a, 0, n);
	return 0;
}


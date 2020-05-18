#include<stdio.h>

int leftChildIndex(int i){	// returns the left child of current node in binary heap
	return (2 * i + 1);
}

int rightChildIndex(int i){ 	// returns the right child of current node in binary heap
	return (2 * i + 2);
}

void swap(int a[], int i, int j){
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
}

void printArray(int a[], int n){
	int i;
	for(i = 0; i < n; i++){
		printf("%d ", a[i]);
	}
	printf("\n");
}

/**
*	a[] -> array to be heapified
*	n -> max element till it will be heapified
*	i -> current node
*/
void maxHeapify(int a[], int n, int i){		
	int left = leftChildIndex(i);
	int right = rightChildIndex(i);
	
	int largest = i;	//	assuming the largest element is at root
	if(left < n && a[left] > a[largest]){	// finding the largest element b/w left child and assumed largest element
		largest = left;
	}
	if(right < n && a[right] > a[largest]){	// finding the largest element b/w right child and assumed largest element
		largest = right;
	}
	if(largest != i){		// If the current assumed index is not largest, then swap it with the largest and call heapify on the swapped element
		printf("swap: %d %d: ", largest, i);
		swap(a, i, largest);
		printArray(a, n);
		maxHeapify(a, n, largest);
	}
}

void buildHeap(int a[], int n){		// build the heap
	int i;
	printf("Building heap:\n");
	for(i = (n / 2 - 1); i >= 0; i--){
		maxHeapify(a, n, i);
	//	printArray(a, n, i);
	}
	printf("Heap built\n\n");
}

void heapSort(int a[], int n){
	buildHeap(a, n);
	int i;
	for(i = n - 1; i > 0; i--){
		printf("iter: %d  : ", i);
		swap(a, 0, i);		// each time swaping the root element with the current element
		printArray(a, n);
		maxHeapify(a, i, 0);		// calling maxHeapify on the current element with the root element as the largest element
	}
}

int main(){
	int n;
	scanf("%d", &n);
	int a[n];
	int i;
	for(i = 0; i < n; i++){
		scanf("%d", &a[i]);
	}
	
	heapSort(a, n);
//	printArray(a, n);
}

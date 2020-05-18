#include<stdio.h>
#include<stdbool.h>
#define PRINT_SELECTION_SORT printf("------ Selection Sort -------\n");
#define PRINT_BUBBLE_SORT printf("------ Bubble Sort -------\n");
#define PRINT_INSERTION_SORT printf("------ Insertion Sort -------\n");

void swap(int *a, int *b){
	int temp = *a;
	*a = *b;
	*b = temp;
}

void printArray(int a[], int n){
	int i;
	for(i = 0; i < n; i++){
		printf("%d ", a[i]);
	}
	printf("\n");
}

void selectionSort(int a[], int n){
	int i, j, minNum, minPos; /* assuming max number is current number */
	for(i = 0; i < n; i++){
		minPos = i;
		minNum = a[minPos];
		for(j = i + 1; j < n; j++){
			if(a[j] < minNum){
				minNum = a[j];
				minPos = j;
			}
		}
		swap(&a[i], &a[minPos]);
		printArray(a, n);
	}
}

void bubbleSort(int a[], int n){
	int i, j, swaps = 1;
	for(i = 0; i < n && swaps > 0; i++){
		swaps = 0;
		for(j = 0; j < n - i - 1; j++){
			if(a[j] > a[j+1]){
				swap(&a[j], &a[j+1]);
				swaps++;
			}
			printArray(a, n);
		}
		printf("\n");
	}
}

void insertionSort(int a[], int n){
	int i, key, j; 
	for (i = 1; i < n; i++) {
		key = a[i]; 
       	j = i - 1; 
		while (j >= 0 && a[j] > key) 
		{ 
           a[j + 1] = a[j]; 
           j--; 
           printArray(a, n);
       	} 
       	a[j + 1] = key; 
   	} 
}

int main(){
	int i, n, curr;
	scanf("%d", &n);
	int a[n], b[n], c[n];
	for(i = 0; i < n; i++){
		scanf("%d", &curr);
		a[i] = curr;
		b[i] = curr;
		c[i] = curr;
	}
	PRINT_SELECTION_SORT
	selectionSort(a, n);
	printArray(a, n);

	PRINT_BUBBLE_SORT
	bubbleSort(b, n);
	printArray(b, n);
	
	PRINT_INSERTION_SORT
	insertionSort(c, n);
	printArray(c, n);
	return 0;
}

#include<stdio.h>
#include<stdbool.h>
#define PRINT_SELECTION_SORT printf("------ Selection Sort -------\n");
#define PRINT_BUBBLE_SORT printf("------ Bubble Sort -------\n");

void swap(int *a, int *b){
	int temp = *a;
	*a = *b;
	*b = temp;
}

void printArray(int a[], int n){
	for(int i = 0; i < n; i++){
		printf("%d ", a[i]);
	}
	printf("\n");
}

void selectionSort(int a[], int n){
	int minNum, minPos; /* assuming max number is current number */
	for(int i = 0; i < n; i++){
		minPos = i;
		minNum = a[minPos];
		for(int j = i + 1; j < n; j++){
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
	int swaps = 1;
	for(int i = 0; i < n && swaps > 0; i++){
		swaps = 0;
		for(int j = 0; j < n - i - 1; j++){
			if(a[j] > a[j+1]){
				swap(&a[j], &a[j+1]);
				swaps++;
			}
			printArray(a, n);
		}
		printf("\n");
	}
}

int main(){
	int n, curr;
	scanf("%d", &n);
	int a[n], b[n];
	for(int i = 0; i < n; i++){
		scanf("%d", &curr);
		a[i] = curr;
		b[i] = curr;
	}
	PRINT_SELECTION_SORT
	selectionSort(a, n);
	printArray(a, n);

	PRINT_BUBBLE_SORT
	bubbleSort(b, n);
	printArray(b, n);
	return EXIT_SUCCESS;
}

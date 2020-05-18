#include<stdio.h>
#include<stdlib.h>

/**
*	Activity selection problem -
*	given n activities with start and end times, select the maximum number of activities 
*	that can be performed by single person assuming no 2 activities can be be performed at a single time.

	Greedy approach -
	1. Sort the activities based on finish time
	2. Print 1st activity
	3. Print which all we can complete after it
*/

void sort(int *a, int *b, int *c, int n);
void swap(int *a, int *b);

int main(){
	int n, i = 0;
	scanf("%d", &n);
	int activity[n], startTime[n], endTime[n];
	for(i = 0; i < n; i++){
		scanf("%d", &startTime[i]);
		activity[i] = i;
	}
	for(i = 0; i < n; i++){
		scanf("%d", &endTime[i]);
	}
	sort(endTime, startTime, activity, n);
	printf("activity %d => [%d - %d]\n", activity[0], startTime[0], endTime[0]);
	for(i = 1; i < n - 1; i++){
		if(endTime[i] < startTime[i + 1]){
			printf("activity %d => [%d - %d]\n", activity[i], startTime[i], endTime[i]);
		}
	}
	if(endTime[n - 2] < startTime[n - 1]){
		printf("activity %d => [%d - %d]\n", activity[i], startTime[i], endTime[i]);
	}
	return 0;
}

void swap(int *a, int *b){
	int temp = *a;
	*a = *b;
	*b = temp;
}

void sort(int a[], int b[], int c[], int n){
	int minNum, minPos, i, j; /* assuming max number is current number */
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
		swap(&b[i], &a[minPos]);		/* sort b on the basis of a for keeping proper index */
		swap(&c[i], &c[minPos]);
	}
}

#include<stdio.h>

int binarySearch(int a[], int low, int high, int k){	
	if(low > high){
		return -1;
	}
	int mid = (low + high)/2;
	if(a[mid] == k){
		return mid;
	} else if(a[mid] < k){
		return binarySearch(a, mid+1, high, k);
	} else {
		return binarySearch(a, low, mid-1, k);
	}
}

int main(){
	int n, k;
	int t;
	scanf("%d", &t);
	while(t--){
		scanf("%d %d", &n, &k);
		int a[n];
		for(int i = 0; i < n; i++){
			scanf("%d", &a[i]);
		}
		printf("%d", binarySearch(a, 0, n, k));
	}
	return 0;
}

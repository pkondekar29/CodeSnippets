#include <stdio.h>

int max(int, int);

int main() {
    int t, n;
    scanf("%d", &t);
    while(t--){
        scanf("%d", &n);
        int a[n];
        for(int i = 0; i < n; i++){
            scanf("%d", &a[i]);
        }
        int i = 1, curr_sum = a[0], max_sum = a[0];
        while(i < n){
            curr_sum = max(a[i], curr_sum + a[i]);
            max_sum = max(curr_sum, max_sum);
            i++;
        }
        printf("%d\n", max_sum);
    }
	return 0;
}

int max(int a, int b){
    if(a > b)   return a;
    else return b;
}
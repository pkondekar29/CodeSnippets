#include <stdio.h>

int main() {
    int t, n, temp, sum;
    scanf("%d", &t);
    while(t--){
        scanf("%d", &n);
        sum = 0;
        for(int i = 0; i < n; i++){
            scanf("%d", &temp);
            sum += temp;
        }
        int nsum = ((n+1) * (n+2))/2;
    }
	return 0;
}
#include <stdio.h>

int main() {
    int t, n, k, i, j, m, temp;
    scanf("%d", &t);
    while(t--){
        scanf("%d &d", &n, &k);
        int a[n];
        for(i = 0; i < n; i++){
            scanf("%d", &a[i]);
        }
        
        for(i = 0; i < n; i++){
            for(j = n - 1; j > 0; j--){
                if(a[j] > a[j - 1]){
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            printf("step %d: ", i);
            for(m = 0; m < n; m++){
	            printf("%d ", a[m]);
	        }
	        printf("\n");
        }
        for(i = 0; i < k; i++){
            printf("%d ", a[i]);
        }
        printf("\n");
    }
    return 0;
}

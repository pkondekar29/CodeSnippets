#include<stdio.h>
#include<stdbool.h>
int main(){
	int t, k, num, n;
	bool found = false;
	scanf("%d", &t); 
	while(t--){
		scanf("%d %d",&n, &k);
		for(int i = 0; i < n; i++){
			scanf("%d", &num);
			if(num == k){
				printf("%d\n", i);
				found = true;
			}
		}
		if(!found){
			printf("-1\n");
		}
	}
	return 0;
}

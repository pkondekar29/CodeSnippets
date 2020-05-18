#include<stdio.h>
#include<stdbool.h>
#include<conio.h>

bool checkUnique(int * hash){
	int i;
    for(i = 0; i < 26; i++){
        if(hash[i] > 1){
            return false;
        }
    }
    return true;
}

int lengthOfLongestSubstring(char * s){
    int i = 0, j = 0;
    int maxLength = 0;
    int alHash[26];
    int k;
    for(k = 0; k < 26; k++) {
        alHash[k] = 0;
    }
    while(s[j] > 'a' && s[j] < 'z'){
        printf("inside");
        alHash[s[j]]++;
        if(checkUnique(alHash)){
            if((j - i + 1) > maxLength){
                maxLength++;
            }
            j++; 
        } else {
            alHash[s[i]]--;
            i++;
        }
        j++;
    }
    return maxLength;
}

int main(){
	char * a;
	int i = 0;
	char c = 'a';
	while ((c = getchar()) != '\n'){
        scanf("%c", &a[i++]);
    	c = getchar();
    }
    for (i = 0; i < 5; i++)
    	printf("%c", a[i]);
	printf(lengthOfLongestSubstring(a));
	return 0;
}

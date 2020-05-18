#include<stdio.h>
#include<stdbool.h>

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
    int i = 0, j = 0, k = 0;
    int maxLength = 0;
    int alHash[26];
    for(k = 0; k < 26; k++) {
        alHash[k] = 0;
    }
    printf("%d", s[j]);
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
	char s[10] = {'a','b','c','c','s','s'};
	printf("%d", lengthOfLongestSubstring(s));
	return 0;
}

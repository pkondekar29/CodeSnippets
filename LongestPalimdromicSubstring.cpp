#include<stdlib.h>
#include<stdio.h>
#include<conio.h>

char * longestPalindrome(char * s){
    int i = 0;
    while(s[i++] != '\0'){
        
    }
    int size = i;
    char r[size];
    
    i = 0;
    while(i < size/2){
        r[i] = s[size - 1];
        r[size - 1] = s[i];
        i++;
        printf("%c", r[i]);
    }
    
    return r;
}

int main(){
	char a[2] = {'a', 'b'};
	longestPalindrome(a);
	return 0;
}

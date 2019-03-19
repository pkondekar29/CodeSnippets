/*
 * =====================================================================================
 *
 *       Filename:  stack.c
 *
 *    Description:  Stack implementation
 *
 *        Version:  1.0
 *        Created:  Tuesday 19 March 2019 08:37:27  IST
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

struct Stack {
	int top;
	int size;
	int *a;
};

struct Stack* initializeStack(int size){
	struct Stack * stack;
	stack = (struct Stack *)malloc(sizeof(struct Stack));
	stack -> top = 0;
	stack -> size = size;
	stack -> a = (int*)malloc( size * sizeof(int));
	return stack;
}

bool isFull(struct Stack * stack){
	return ((stack -> top) == (stack -> size));
}

bool isEmpty(struct Stack * stack){
	return ((stack -> top) == 0);
}

int pop(struct Stack * stack){
	if(!isEmpty(stack)){
		(stack -> top)--;
		return stack -> a[stack -> top];
	}
}

void push(struct Stack * stack, int value){
	if(!isFull(stack)){
		stack -> a[stack -> top] = value;
		(stack -> top)++;
	}
}

void printAll(struct Stack * myStack){
	for(int i = 0; i < myStack -> top; i++){
		printf("%d ", myStack -> a[i]);
	}
	printf("\n");
}

int main(){
	struct Stack * myStack;
	bool stop = false;
	int size, value, operation;
	printf("Enter size: ");
	scanf("%d", &size);
	myStack = initializeStack(size);
	while(!stop){
		printf("What do you want to do?\n1. Add\n2. Remove\n3. Print all\n0. Exit\n");
		scanf("%d", &operation);
		switch(operation){
			case 0:
				stop = true;
				break;
			case 1:
				printf("Enter number: ");
				scanf("%d", &value);
				push(myStack, value);
				break;
			case 2:
				printf("Removed: %d\n", pop(myStack));
				break;
			case 3:
				printAll(myStack);
				break;
			default:
				break;
		}
	}
}


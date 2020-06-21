package CodeSnippets;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        boolean balanced = true;
        for(int i = 0; i < str.length() && balanced; i++){
            Character c = str.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) balanced = false;
                else {
                    Character popped = stack.pop();
                    if(!((c == ']' && popped == '[') || (c == '}' && popped == '{') || (c == ')' && popped == '('))) {
                        balanced = false;
                    }
                }
            }
        }
        if(!stack.isEmpty()) balanced = false;
        if(balanced) System.out.println("balanaced");
        else System.out.println("not balanced");
    }

}
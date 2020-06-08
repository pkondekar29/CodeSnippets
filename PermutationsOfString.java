package CodeSnippets;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationsOfString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        findAllPermutations(new String(chars), new char[str.length()], 0);
        
        sc.close();
    }

    private static void findAllPermutations(String str, char[] chars, int j){
        if(j == str.length()) {
            if(allUnique(chars)){
                System.out.println(new String(chars));
            }
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            chars[j] = str.charAt(i);
            findAllPermutations(str, chars, j + 1);
        }
    }

    private static boolean allUnique(char[] chars) {
        int[] hist = new int[26];
        Arrays.fill(hist, 0);
        
        for(int i = 0; i < chars.length; i++) {
            hist[chars[i] - 'A']++;
        }
        for(int i = 0; i < 26; i++){
            if(hist[i] > 1) {
                return false;
            }
        }
        return true;
    }

}
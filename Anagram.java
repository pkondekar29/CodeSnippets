package CodeSnippets;

import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isAnagram(sc.next(), sc.next()) ? "An" : "NAn");
        sc.close();
    }

    /**
     * This logic doesn't work since there can be 2 bytes with same 1s and 0s.
     * 
     */
    private static boolean isAnagram(String s1, String s2){

        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        
        int xor = 0;
        for(int i = 0; i < char1.length; i++){
            xor ^= char1[i] ^ char2[i];
        }
        return xor == 0;

    }

}
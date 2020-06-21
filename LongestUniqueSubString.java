package CodeSnippets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LongestUniqueSubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] hist = new int[26];
        Arrays.fill(hist, -1);
        int currMax = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (hist[c - 'a'] != -1) {
                final int lastIndex = hist[c - 'a'];
                currMax = i - lastIndex;
                for (int k = 0; k < 26; k++) {
                    if (hist[k] <= lastIndex)
                        hist[k] = -1;
                }
            } else {
                currMax++;
                if (currMax > max) {
                    max = currMax;
                }
            }
            hist[c - 'a'] = i;
        }
        System.out.println(max);
        sc.close();
    }

}
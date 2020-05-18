import java.util.Scanner;

public class LongestCommonPalindrome{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();

        System.out.println(lcp(str));

        sc.close();

    }

    private static String lcp(String s){
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int max = 1, pos = 0;
        for (int i = 0; i < n; ++i) 
            dp[i][i] = true; 
  
        // check for sub-string of length 2. 
        for (int i = 0; i < n - 1; ++i) { 
            if (s.charAt(i) == s.charAt(i + 1)) { 
                dp[i][i + 1] = true; 
                pos = i; 
                max = 2; 
            } 
        } 
        printDp(dp, n);

        for (int k = 3; k <= n; ++k) { 
              
            // Fix the starting index 
            for (int i = 0; i < n - k + 1; ++i)  { 
            // Get the ending index of substring from 
            // starting index i and length k 
            int j = i + k - 1; 

            // checking for sub-string from ith index to 
            // jth index iff str.charAt(i+1) to  
            // str.charAt(j-1) is a palindrome 
            if (dp[i + 1][j - 1] && s.charAt(i) ==  
                                        s.charAt(j)) { 
                dp[i][j] = true; 

                if (k > max) { 
                    pos = i; 
                    max = k; 
                } 
            } 
        } 
  } 
        printDp(dp, n);
        return s.substring(pos, pos + max);

    }

    private static void printDp(boolean[][] dp, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(dp[i][j] ? 1 : 0);
            }
            System.out.println();
        }
        System.out.println();
    }

}
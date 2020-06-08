package CodeSnippets;
public class LongestPalimdrome {
    private static String longestPalindrome(String s) {
        String r = new StringBuilder().append(s).reverse().toString();
        int n = s.length();
        int [][] a = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            a[i][0] = 0;
            a[0][i] = 0;
        }
        int p = 0, max = 0;
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(s.charAt(i - 1) == r.charAt(j - 1) && s.charAt(j - 1) == s.charAt(j - a[i-1][j-1] - 1)) {
                    a[i][j] = a[i-1][j-1] + 1;
                    if(a[i][j] > max){
                        max = a[i][j];
                        p = i;
                    }
                } else {
                    a[i][j] = 0;
                }
            }
        }
        return s.substring(p - max - 1, p - 1);
    }

    public static void main(String[] args){
	    String s = "aacdefcaa";
	    System.out.println(longestPalindrome(s));
    }
}

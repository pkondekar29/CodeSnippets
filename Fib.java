import java.util.Scanner;

public class Fib {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        // System.out.println(fibRecurssive(n));
        // int [] memo = new int[n + 1];
        // for(int i = 0; i < n + 1; i++){
        //     memo[i] = 0;
        // }
        // System.out.println(fibDP(n, memo));
        System.out.println(fibBottomUp(n));
        scanner.close();
    }

    /**
     * Naive approach
     * @param n
     * @return
     */
    private static int fibRecurssive(int n) {
        if(n == 1 || n == 2){
            return 1;
        } else {
            return fibRecurssive(n - 1) + fibRecurssive(n - 2);
        }
    }

    /**
     * Memoisation approach to DP
     * @param n
     * @param memo
     * @return
     */
    private static int fibDP(int n, int[] memo){
        if(memo[n] != 0) {
            return memo[n];
        }

        int result;
        if(n == 1 || n == 2){
            result = 1;
        } else {
            result = fibDP(n - 1, memo) + fibDP(n - 2, memo);
        }
        memo[n] = result;
        return result;
    }

    /**
     * Bottom up approach to DP
     */
    private static int fibBottomUp(int n){

        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 1;

        for(int i = 3; i < n + 1; i++){
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];

    }

}
package solutions.misc;

class Fibonacci {
    public int fib(int n) {
        int[] dp = new int[31];
        dp[1] = 1;
        return fib(n, dp);
    }

    public int fib(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        
        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }
}

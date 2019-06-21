public class PerfectSquares {
    public int numSquares(int n) {
        if (n < 4)
            return n;

        int[] dp = new int[n + 1];


        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if (dp[i] == 1)
                continue;

            dp[i] = n;
            for (int j = 1; j * j < i; j++) {
                int k = i / (j * j);
                dp[i] = Math.min(dp[i], k + dp[i - k * j * j]);
            }

        }

        return dp[n];
    }
}

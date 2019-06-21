/*
https://leetcode.com/problems/guess-number-higher-or-lower-ii/
medium
solution: dp minmaximum
 */

public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1]; // dp[i][j] [i, j]范围内找到数字的最大代价

        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i >= 1; i--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int local = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    globalMin = Math.min(globalMin, local);
                }

                dp[i][j] = i + 1 == j ? i : globalMin;
            }
        }

        return dp[1][n];
    }
}

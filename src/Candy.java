/*
https://leetcode.com/problems/candy/
hard
solution: greedy 2 directions
 */

public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        if (ratings.length == 1) {
            return 1;
        }

        int n = ratings.length;
        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                dp[i - 1] = Math.max(dp[i] + 1, dp[i - 1]);
            }
        }

        int res = 0;

        for (int num: dp) {
            res += num;
        }

        return res;
    }
}

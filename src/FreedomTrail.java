/*
https://leetcode.com/problems/freedom-trail/
hard
solution: dp dp[i][j] means min step let ring[j] == key[i]; i--; return dp[0][0] + m
http://www.cnblogs.com/grandyang/p/6675879.html
 */

public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        int m = key.length(), n = ring.length();
        int[][] dp = new int[m + 1][n]; // min step let ring[j] == key[i]

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }

        return dp[0][0] + m;
    }
}

/*
https://leetcode.com/problems/distinct-subsequences/
hard
solution: dp  https://leetcode.com/problems/distinct-subsequences/
 */

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }

        int ls = s.length(), lt = t.length();
        int[][] dp = new int[lt + 1][ls + 1]; // dp[i][j] means how many t(0-->i-1) can be find be found in  s(0-->j-1)
        for (int j = 0; j <= ls; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= lt; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= lt; i++) {
            for (int j = 1; j <= ls; j++) {
                if (t.charAt(i-1) != s.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
            }
        }

        return dp[lt][ls];
    }
}

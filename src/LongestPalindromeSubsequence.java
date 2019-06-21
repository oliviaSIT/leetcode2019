/*
https://leetcode.com/problems/longest-palindromic-subsequence/
medium
sol: dp rolling
 */

public class LongestPalindromeSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[2][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i % 2][i] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i % 2][j] = (i + 1 == j) ? 2 : 2 + dp[(i + 1) % 2][j - 1];
                else dp[i % 2][j] = Math.max(dp[(i + 1) % 2][j], dp[i % 2][j - 1]);
            }
        }

        return dp[0][s.length() - 1];
    }
}

/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = (i + 1 == j) ? 2 : 2 + dp[i + 1][j - 1];
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][s.length() - 1];
    }
}
 */

/*
https://leetcode.com/problems/is-subsequence/
medium
solution: dp
 */

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;

        if (s.length() == 0)
            return true;

        int m = s.length(), n = t.length();
        boolean[][] dp = new boolean[m][n];// if s[0-i] is the sub of t[0-j]

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(0) == t.charAt(i)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int j = index; j < n; j++)
                dp[0][j] = true;
        }

        for (int i = 1; i < m; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = dp[i][j - 1] || (dp[i - 1][j - 1] && s.charAt(i) == t.charAt(j));
            }
        }

        return dp[m - 1][n - 1];
    }
}

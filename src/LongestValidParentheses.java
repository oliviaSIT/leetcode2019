/*
https://leetcode.com/problems/longest-valid-parentheses/solution/
hard
solution: dp  case: s[i] = '(' s[i] = ')' && s[i - 1] = '(' s[i] = ')' && s[i - 1] = ')'
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 0;

        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == ')') {
                if (c[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i- dp[i - 1] > 0 && c[i - dp[i - 1] - 1] == '(') {
                        dp[i] = (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2 + dp[i - 1];
                    }
                }

                res = Math.max(res, dp[i]);
            }

        }

        return res;
    }
}

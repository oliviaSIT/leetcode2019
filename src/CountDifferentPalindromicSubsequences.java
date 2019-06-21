public class CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int n = s.length();
        int[][] dp = new int[n][n]; // dp[i][j] si->sj how many different palindromic subsequences

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] * 2;

                    int l = i + 1, r = j - 1;
                    while (l <= r && s.charAt(l) != s.charAt(i))
                        l++;

                    while (l <= r && s.charAt(r) != s.charAt(i))
                        r--;

                    if (l == r) // case 1: bcbcb
                        dp[i][j] += 1;

                    else if (l > r) // case 2: bcb
                        dp[i][j] += 2;

                    else dp[i][j] -= dp[l + 1][r - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]; // case4: acb
                }

                dp[i][j] = (dp[i][j] + kMod) % kMod;
            }

        }

        return dp[0][n - 1];
    }

    private static int kMod = 1000000007;
}

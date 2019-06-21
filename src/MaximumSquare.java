/*
https://leetcode.com/problems/maximal-square/
medium
solution:dp 类文氏图
https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-221-maximal-square/
 */

public class MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];//(0,0)为顶点，(i-1, j-1)为顶点的矩阵内数字和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + (matrix[i - 1][j - 1] - '0');
            }
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = Math.min(m - i + 1, n - j + 1); k > 0; k--) {
                    int sum = dp[i + k - 1][j + k - 1] - dp[i - 1][j + k - 1] - dp[i + k - 1][j - 1] + dp[i - 1][j - 1];

                    if (sum == k * k) {
                        res = Math.max(res, sum);
                        break;
                    }
                }
            }
        }

        return res;
    }
}

/*
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length, maxLen = 0;
        int[][] dp = new int[2][n]; // dp[i][j] means the length of biggerst square when it turns to [i, j];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            maxLen = Math.max(maxLen, dp[0][j]);
        }

        for (int i = 1; i < m; i++) {
            dp[i % 2][0] = matrix[i][0] - '0';
            maxLen = Math.max(maxLen, dp[i % 2][0]);

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0')
                    dp[i % 2][j] = 0;
                else dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1])) + 1;

                maxLen = Math.max(maxLen, dp[i % 2][j]);
            }
        }

        return maxLen * maxLen;
    }
}
 */

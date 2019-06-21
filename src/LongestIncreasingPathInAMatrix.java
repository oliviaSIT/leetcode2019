/*
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/
hard
solution: dfs+记忆化
https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-329-longest-increasing-path-in-a-matrix/
 */

import java.util.*;

public class LongestIncreasingPathInAMatrix {
    public int m, n;
    public int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }

        return  res;
    }

    private int dfs(int[][] matrix, int x , int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 1;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] > matrix[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(matrix, nx, ny));
            }
        }

        return dp[x][y];
    }
}

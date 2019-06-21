/*
https://leetcode.com/problems/remove-boxes/
hard
solution: dp, dfs + memory
https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-546-remove-boxes/
 */

public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n]; // dp[l][r][k] means the max points if remove the l-r boxes where k boxes are the same color as box[r] following box[r]
        return dfs(dp, boxes, 0, n - 1, 0);
    }

    private int dfs(int[][][] dp, int[] boxes, int l, int r, int k) {
        if (l > r)
            return 0;

        if (dp[l][r][k] > 0)
            return dp[l][r][k];

        // case 1: remove the boxes[r]
        dp[l][r][k] = dfs(dp, boxes, l, r - 1, 0) + (k + 1) * (k + 1);

        // case 2: break l - p, p - r-1, r - n, if boxes[p] == boxes[r]
        for (int p = l; p < r; p++) {
            if (boxes[p] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], dfs(dp, boxes, l, p, k + 1) + dfs(dp, boxes, p + 1, r - 1, 0));
            }
        }

        return dp[l][r][k];
    }
}

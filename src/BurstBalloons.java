/*
https://leetcode.com/problems/burst-balloons/
hard
solution: dp
https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-312-burst-balloons/
 */

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] Nums = new int[nums.length + 2];
        Nums[0] = 1;
        Nums[nums.length + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            Nums[i] = nums[i - 1];
        }

        int[][] dp = new int[Nums.length][Nums.length]; // dp[i][j] means the max coins we can get from the ith balloon to the jth balloon
        for (int l = 1; l <= nums.length; l++) {
            for (int i = 1; i <= nums.length - l + 1; i++) {
                int j = i + l - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + Nums[i - 1] * Nums[k] * Nums[j + 1] + dp[k + 1][j]);
                }
            }
        }

        return dp[1][nums.length];
    }
}

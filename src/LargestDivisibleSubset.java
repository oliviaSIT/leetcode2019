/*
https://leetcode.com/problems/largest-divisible-subset/
medium:
solution: dp[i]从后往前到nums[i]为止的最长子序列长度 parent记录上一个能整除nums[i]的数的index
http://www.cnblogs.com/grandyang/p/5625209.html
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        int mx = 0, mx_idx = 0;//mx: max len of subset, mx_idx the start of subset;
        int[] parent = new int[nums.length];
        int[] dp = new int[nums.length];//dp[i] 从后往前到nums[i]为止的最长子序列长度

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;

                    if (mx < dp[i]) {
                        mx = dp[i];
                        mx_idx = i;
                    }
                }
            }
        }

        for (int i = 0; i < mx; i++) {
            res.add(nums[mx_idx]);
            mx_idx = parent[mx_idx];
        }

        return res;
    }
}

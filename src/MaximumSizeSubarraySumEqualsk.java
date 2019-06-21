/*
https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
medium
sol: use map to record the exist sum
 */

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0, sum = 0;
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k)
                res = i + 1;
            else if (m.containsKey(sum - k))
                res = Math.max(res, i - m.get(sum - k));

            if (!m.containsKey(sum))
                m.put(sum, i);
        }

        return res;
    }
}

/*
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }
}
 */
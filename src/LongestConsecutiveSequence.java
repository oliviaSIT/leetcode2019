/*
https://leetcode.com/problems/longest-consecutive-sequence/
hard
solution: hash, find the low bounder and high bounder, find the max high - low
https://zxi.mytechroad.com/blog/hashtable/leetcode-128-longest-consecutive-sequence/
 */

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null)
            return 0;

        if (nums.length < 2)
            return nums.length;

        Set<Integer> dict = new HashSet<>();

        for (int num: nums) {
            dict.add(num);
        }

        int res = 0;
        for (int num: nums) {
            int t = 0;
            // if dict does not contain num-1, num is the low bounder
            if (!dict.contains(num - 1)) {
                while (dict.contains(num + t)) {
                    t++;
                }

                res = Math.max(res, t);
            }
        }

        return res;
    }
}

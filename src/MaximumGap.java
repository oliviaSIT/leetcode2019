/*
https://leetcode.com/problems/maximum-gap/
hard
solution: bucket sort, answer exists in 2 adjacent buckets, min[i] - max[pre]
http://www.cnblogs.com/grandyang/p/4234970.html
 */

import java.util.*;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int n = nums.length;
        int max = nums[0], min = nums[0];
        for (int num: nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int gap = (max - min) / n + 1;
        int numBucket = (max - min) / gap + 1;

        int[] minBucket = new int[numBucket];
        int[] maxBucket = new int[numBucket];

        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        Set<Integer> v = new HashSet<>();

        for (int num: nums) {
            int index = (num - min) / gap;
            minBucket[index] = Math.min(minBucket[index], num);
            maxBucket[index] = Math.max(maxBucket[index], num);
            v.add(index);
        }

        int pre = 0, res = 0;
        for (int i = 1; i < numBucket; i++) {
            if (v.contains(i)) {
                res = Math.max(res, minBucket[i] - maxBucket[pre]);
                pre = i;
            }
        }

        return res;
    }
}

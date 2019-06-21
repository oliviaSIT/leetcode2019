/*
https://leetcode.com/problems/create-maximum-number/
hard
solution: 分解为2个子问题 1.从nums1中找出合适的K个数 greedy 2.合并2个数组
https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-321-create-maximum-number/
 */

import java.util.Stack;

public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];

        for (int k1 = 0; k1 <= k; k1++) {
            int k2 = k - k1;
            if (k1 > nums1.length || k2 > nums2.length)
                continue;

            res = Max(res, 0, Merge(Max(nums1, k1), Max(nums2, k2)), 0);
        }

        return res;
    }

    private int[] Max(int[] nums, int k) {
        int[] res = new int[k];

        if (k == 0) {
            return res;
        }

        Stack<Integer> s = new Stack<>();
        int canPop = nums.length - k;

        for (int num: nums) {
            while (!s.isEmpty() && num > s.peek() && canPop > 0) {
                s.pop();
                canPop--;
            }

            s.push(num);
        }

        while (s.size() > k) {
            s.pop();
        }

        for (int i = k - 1; i >= 0; i--) {
            res[i] = s.pop();
        }

        return res;
    }

    private int[] Merge(int[] n1, int[] n2) {
        if (n1.length == 0) {
            return n2;
        }

        if (n2.length == 0) {
            return n1;
        }

        int i = 0, j = 0, k = 0;
        int[] res = new int[n1.length + n2.length];
        while (i < n1.length || j < n2.length) {
            res[k++] = Max(n1, i, n2, j) == n1 ? n1[i++] : n2[j++];
        }

        return res;
    }

    private int[] Max(int[] nums1, int s1, int[] nums2, int s2) {
        for (int i = s1; i < nums1.length; ++i) {
            int j = s2 + i - s1;
            if (j >= nums2.length) return nums1;
            if (nums1[i] < nums2[j]) return nums2;
            if (nums1[i] > nums2[j]) return nums1;
        }
        return nums2;
    }
}

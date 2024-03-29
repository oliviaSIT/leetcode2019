/*
https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
hard
solution: binary search  median index k = m1 + m2 = (n1 + n2 + 1)/2 c1 left median = max a[m1 - 1] b[m2 - 1]c2 right median = min a[m1] b[m2]
https://zxi.mytechroad.com/blog/algorithms/binary-search/leetcode-4-median-of-two-sorted-arrays/
 */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int k = (n1 + n2 + 1) / 2; // index of median
        int l = 0, r = n1;

        while (l < r) {
            int m1 = l + (r - l) / 2; // array1 0-m1-1
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]) {
                l = m1 + 1;
            } else {
                r = m1;
            }
        }

        int m1 = l, m2 = k - l;

        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

        if ((n1 + n2) % 2 == 1) {
            return c1;
        }

        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1], m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;
    }
}

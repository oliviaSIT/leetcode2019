/*
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
medium
solution: priorityqueue
 */

import java.util.*;

public class FindKPairsWithSmallestPairs {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        int l = Math.min(k, nums1.length * nums2.length);
        PriorityQueue<int[]> q = new PriorityQueue<>(l, new Comparator<int[]>() {
            public int compare(int[] a2, int[] a1) {
                return a1[0] + a1[1] - a2[0] - a2[1];
            }
        });

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (q.size() < k) {
                    q.offer(new int[]{nums1[i],nums2[j]});
                } else if (nums1[i] + nums2[j] < (q.peek()[0] + q.peek()[1])) {
                    q.poll();
                    q.offer(new int[]{nums1[i], nums2[j]});
                }
            }
        }

        while (!q.isEmpty()) {
            res.add(q.poll());
        }

        return res;
    }
}

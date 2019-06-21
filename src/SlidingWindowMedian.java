/*
https://www.lintcode.com/problem/sliding-window-median/description?_from=ladder&&fromId=46
hard
sol: use maxheap to record num that is smaller than median minheap->bigger the peek of maxheap is the median
 */

import java.util.*;

public class SlidingWindowMedian {
    private PriorityQueue<Integer> minHeap, maxHeap;

    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        int n = nums.length;
        minHeap = new PriorityQueue<>(n); // nums in this heap are bigger than median
        maxHeap = new PriorityQueue<>(n, Collections.reverseOrder());// smaller
        for (int i = 0; i < n; i++) {
            if (maxHeap.size() == 0 || nums[i] < maxHeap.peek())
                maxHeap.offer(nums[i]);
            else minHeap.offer(nums[i]);

            balance();

            if (i >= k) { // remove passed num
                if (nums[i - k] > maxHeap.peek())
                    minHeap.remove(nums[i - k]);
                else maxHeap.remove(nums[i - k]);

                balance();
            }

            if (i >= k - 1)
                res.add(maxHeap.peek());
        }

        return res;
    }

    private void balance() {
        while (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());

        while (minHeap.size() < maxHeap.size() - 1)
            minHeap.offer(maxHeap.poll());
    }
}

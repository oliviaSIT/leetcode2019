/*
https://leetcode.com/problems/sliding-window-maximum/
hard
solution: dequeue,单调递减
https://zxi.mytechroad.com/blog/heap/leetcode-239-sliding-window-maximum/
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0)
            return nums;

        List<Integer> res = new ArrayList<>();
        Deque<Integer> index = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (index.size() > 0 && nums[i] >= nums[index.getLast()])
                index.removeLast();

            index.addLast(i);

            if (i - k  + 1 >= 0)
                res.add(nums[index.getFirst()]);

            if (i - k + 1 >= index.getFirst())
                index.removeFirst();
        }

        int[] ans = new int[res.size()];

        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);

        return ans;
    }
}

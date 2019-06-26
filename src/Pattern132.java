/*
https://leetcode.com/problems/132-pattern/
medium
sol: stack
 */

import java.util.Stack;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;

        Stack<Integer> smaller = new Stack<>();// the number smaller than nums[i]
        int maxSmaller = Integer.MIN_VALUE;//the biggest number smaller than nums[i]

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < maxSmaller)
                return true;
            else {
                while (!smaller.isEmpty() && nums[i] > smaller.peek()) {
                    maxSmaller = smaller.pop();
                }

                smaller.push(nums[i]);
            }
        }

        return false;
    }
}

/*
https://leetcode.com/problems/next-greater-element-ii/
medium
sol: stack
 */

import java.util.*;

public class NextGreaterNumberII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];

        if (nums == null || nums.length == 0)
            return res;

        Stack<Integer> s = new Stack<>();
        Map<Integer, Queue<Integer>> m = new HashMap<>();

        for (int n: nums) {
            while (s.size() != 0 && n > s.peek()) {
                int t = s.pop();
                Queue<Integer> q = m.getOrDefault(t, new LinkedList<>());
                q.offer(n);
                m.put(t, q);
            }

            s.push(n);
        }

        for (int n: nums) {
            while (s.size() != 0 && n > s.peek()) {
                int t = s.pop();
                Queue<Integer> q = m.getOrDefault(t, new LinkedList<>());
                q.offer(n);
                m.put(t, q);
            }

            s.push(n);
        }

        for (int i = 0; i < res.length; i++) {
            if (m.containsKey(nums[i])) {
                //Queue<Integer> x = m.getOrDefault(nums[i], new LinkedList<>());
                Queue<Integer> x = m.get(nums[i]);
                res[i] = x.poll();
            } else
                res[i] = -1;
        }

        return res;
    }
}

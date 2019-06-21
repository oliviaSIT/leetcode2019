/*
https://leetcode.com/problems/next-greater-element-i/
easy
solution: stack
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterNumberI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();

        for (int num: nums2) {
            while (s.size() != 0 && num > s.peek()) {
                nextGreater.put(s.peek(), num);
                s.pop();
            }

            s.push(num);
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return res;
    }
}

/*
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        int[] res = new int[n1];

        if (n1 == 0)
            return res;

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            int nGreater = -1;

            for (int j = i + 1; j < n2; j++) {
                if (nums2[j] > nums2[i]) {
                    nGreater = nums2[j];
                    break;
                }
            }

            m.put(nums2[i], nGreater);
        }

        for (int i = 0; i < n1; i++) {
            res[i] = m.get(nums1[i]);
        }

        return res;
    }
}
 */
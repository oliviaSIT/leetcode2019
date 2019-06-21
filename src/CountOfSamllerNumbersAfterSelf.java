/*
https://leetcode.com/problems/count-of-smaller-numbers-after-self/
hard
solution: bst
 */

import java.util.*;

public class CountOfSamllerNumbersAfterSelf {
    class Node {
        public int val, count, left_count;
        public Node left, right;

        public Node(int val) {
            this.val = val;
            this.count = 1;
        }

        public int lessOrEqual() {
            return this.count +this.left_count;
        }

    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        int n = nums.length;
        Node root = new Node(nums[n - 1]);
        res.add(0);

        for (int i = n - 2; i >= 0; i--) {
            res.add(insert(root, nums[i]));
        }

        Collections.reverse(res);

        return res;
    }

    private int insert(Node root, int val) {
        if (root.val == val) {
            root.count++;
            return root.left_count;
        } else if (root.val > val) {
            root.left_count++;

            if (root.left == null) {
                root.left = new Node(val);
                return 0;
            } else return insert(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new Node(val);
                return root.lessOrEqual();
            } else return root.lessOrEqual() + insert(root.right, val);
        }
    }
}

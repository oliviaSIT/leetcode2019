/*
https://leetcode.com/problems/find-bottom-left-tree-value/
medium
solution: bfs
 */

import java.util.*;

public class FindbottemLeftTreeValue {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                l.add(node.val);
                if (node.right != null)
                    q.offer(node.right);

                if (node.left != null)
                    q.offer(node.left);
            }
        }

        return l.get(l.size() - 1);
    }
}

/*
https://leetcode.com/problems/binary-tree-inorder-traversal/
medium

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinayTreeInorderTraveral {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            TreeNode node = s.pop();
            res.add(node.val);

            root = node.right;

        }

        return res;
    }
}

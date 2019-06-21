/*
https://leetcode.com/problems/insert-into-a-binary-search-tree/
medium
sol: recursive or iterative sol
 */

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode t = root;
        TreeNode v = new TreeNode(val);

        while (true) {
            if (t == null)
                return v;

            if (t.val > val) {
                if (t.left == null) {
                    t.left = v;
                    break;
                } else {
                    t = t.left;
                }
            } else {
                if (t.right == null) {
                    t.right = v;
                    break;
                } else {
                    t = t.right;
                }
            }
        }

        return root;
    }
}

/*
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);

        if (root.val > val)
            root.left = insertIntoBST(root.left, val);

        if (root.val < val)
            root.right = insertIntoBST(root.right, val);

        return root;
    }
}
 */
/*
https://leetcode.com/problems/largest-bst-subtree/
medium
solution: dfs, if is Bst count node
 */

public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        if (isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE))
            return count(root);

        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isValid(TreeNode root, int max, int min) {
        if (root == null)
            return true;

        if (root.val >= max || root.val <= min)
            return false;

        boolean l = isValid(root.left, root.val, min);
        boolean r = isValid(root.right, max, root.val);

        return l && r;
    }

    private int count(TreeNode root) {
        if (root == null)
            return 0;

        return count(root.left) + count(root.right) + 1;
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) { this.val = val;}
}
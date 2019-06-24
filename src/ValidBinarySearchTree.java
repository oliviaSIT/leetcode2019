/*
https://leetcode.com/problems/validate-binary-search-tree/
medium
solution: find the max value of left subtree and the min value of right subtree, compare with current node
          design a class Result
          null???
 */

public class ValidBinarySearchTree {
    public class Result {
        boolean isValid;
        TreeNode min, max;

        public Result(boolean v, TreeNode Min, TreeNode Max) {
            this.isValid = v;
            this.min = Min;
            this.max = Max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return help(root).isValid;
    }

    private Result help(TreeNode root) {
        if (root == null) {
            return new Result(true, null, null);
        }

        Result l = help(root.left);
        Result r = help(root.right);

        if (!l.isValid || !r.isValid)
            return new Result(false, null, null);

        if (l.max != null && root.val <= l.max.val)
            return new Result(false, null, null);

        if (r.min != null && root.val >= r.min.val)
            return new Result(false, null, null);

        TreeNode min = null;
        TreeNode max = null;

        if (l.min != null)
            min = l.min;
        else min = root;

        if (r.max != null)
            max = r.max;
        else max = root;

        return new Result(true, min, max);
    }
}

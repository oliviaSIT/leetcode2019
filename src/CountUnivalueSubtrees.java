/*
https://leetcode.com/problems/count-univalue-subtrees/
medium
soluton: dfs
 */

public class CountUnivalueSubtrees {
    public int res;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        res = 0;
        dfs(root);

        return res;
    }

    private boolean dfs(TreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null) {
            res++;
            return true;
        }

        boolean l = dfs(root.left);
        boolean r = dfs(root.right);

        if (l && r) {
            if (root.left != null && root.right != null) {
                if (root.val == root.left.val && root.val == root.right.val) {
                    res++;
                    return true;
                }

                return false;
            }

            if (root.left != null && root.val == root.left.val) {
                res++;
                return true;
            }

            if (root.right != null && root.val == root.right.val) {
                res++;
                return true;
            }

            return false;
        }

        return false;
    }
}

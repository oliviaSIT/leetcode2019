/*
https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
medium
solution: 1. stack
 2.对于二叉树，我们把空的地方也作为叶子节点（如题目中的#），那么有

所有的非空节点提供2个出度和1个入度（根除外）
所有的空节点但提供0个出度和1个入度
我们在遍历的时候，计算diff = outdegree – indegree. 当一个节点出现的时候，diff – 1，因为它提供一个入度；当节点不是#的时候，diff+2(提供两个出度) 如果序列式合法的，那么遍历过程中diff >=0 且最后结果为0
https://www.hrwhisper.me/leetcode-verify-preorder-serialization-of-a-binary-tree/
 */

public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int diff = 1; // outdegree - indgree;

        for (String str: strs) {
            diff--;
            if (diff < 0)
                return false;

            if (!str.equals("#"))
                diff += 2;
        }

        return diff == 0;
    }
}

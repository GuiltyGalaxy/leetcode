package top.L473;

import tool.TreeNode;

class Solution {
    private int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        pathSumHelper(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return res;
    }

    private void pathSumHelper(TreeNode node, int targetSum, long currentsum) {
        if (node == null) {
            return;
        }

        currentsum += node.val;
        if (currentsum == targetSum) {
            res++;
        }

        pathSumHelper(node.left, targetSum, currentsum);
        pathSumHelper(node.right, targetSum, currentsum);
    }
}
package top.L543;

import tool.TreeNode;

class Solution {
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        // 左右樹的深度相加就是最遠距離
        diameter = Math.max((right + left), diameter);
        return Math.max(left, right) + 1;
    }
}
package top.L236;

import tool.TreeNode;

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 到底了
        if (root == null) {
            return null;
        }

        // 有符合其中一個則返回
        if ( root.val == p.val || root.val == q.val) {
            return root;
        }

        // 向左右找出lowestCommonAncestor
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 當左右都有找到則該點為lowestCommonAncestor
        if (left != null && right != null) {
            return root;
        }

        // 只找到其中一邊則返回有找到的那個
        return left != null ? left : right;
    }

}
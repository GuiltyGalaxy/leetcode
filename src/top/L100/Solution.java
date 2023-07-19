package top.L100;

import tool.TreeNode;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        // 節點不相等
        if (p == null || q == null) {
            return false;
        }

        // val不相等
        if (p.val != q.val) {
            return false;
        }

        // 往下找
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
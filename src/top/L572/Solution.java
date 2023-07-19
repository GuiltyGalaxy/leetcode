package top.L572;

import tool.TreeNode;

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        // 以當前的值去check
        // 非答案時往下遞歸找left,right
        return isSameTree(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    /**
     * 檢查Tree是否相同
     */
    private boolean isSameTree(TreeNode first, TreeNode second) {

        if (first == null && second == null) return true;
        if (first == null || second == null) return false;
        if (first.val != second.val) return false;

        // 後面可以也用isSameTree(4 ms)
        // 但不知為什麼使用isSubtree會更快(1 ms)
        return isSameTree(first.left, second.left) && isSubtree(first.right, second.right);
    }
}
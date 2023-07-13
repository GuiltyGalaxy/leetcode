package top.L98;


import tool.TreeNode;

class Solution {
    private long minVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 採用inorder，BST壓成一條線就是個排序好的直線
        if (!isValidBST(root.left)) {
            return false;
        }

        // 所以後一個值一定比前一個大
        if (minVal >= root.val) {
            return false;
        }

        // 再驗證途中更新最小值
        minVal = root.val;

        return isValidBST(root.right);
    }
}
package top.L230;

import tool.TreeNode;

class Solution {
    int cnt;
    int targetK;
    int kth;

    public int kthSmallest(TreeNode root, int k) {
        targetK = k;
        inorder(root);
        return kth;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        // inorder在BST中會按照順序
        inorder(root.left);
        cnt++;
        // 所以cnt相等時剛好就是第k小的數
        if (cnt == targetK) {
            kth = root.val;
            return;
        }
        inorder(root.right);
    }
}
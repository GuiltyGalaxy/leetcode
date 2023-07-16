package top.L105;

import tool.TreeNode;

class Solution {
    private int inorderIndex = 0;
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return create(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode create(int[] preorder, int[] inorder, int stop) {

        if (preorderIndex >= preorder.length) {
            return null;
        }

        // 當遇到上個preorder節點為目前inorder的值
        // 代表要切分，所以inorderIndex++返回
        if (inorder[inorderIndex] == stop) {
            inorderIndex++;
            return null;
        }

        TreeNode n = new TreeNode(preorder[preorderIndex++]);
        n.left = create(preorder, inorder, n.val);
        n.right = create(preorder, inorder, stop);

        return n;
    }
}
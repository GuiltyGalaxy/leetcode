package top.L235;

import tool.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        // 由於是BST，所以可依數值比較出要往哪個方向找
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // root.val在p.val與q.val之間代表該節點為Ancestor
        return root;
    }
}
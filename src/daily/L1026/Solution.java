package daily.L1026;

import tool.TreeNode;

class Solution {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int mx, int mn) {

        if (root == null) {
            //找到結尾把mx - mn則為最大abs(因只保留最大最小)
            return mx - mn;
        }
        //只保留最大最小往下尋找
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);

        return Math.max(dfs(root.left, mx, mn), dfs(root.right, mx, mn));
    }
}
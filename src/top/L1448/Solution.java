package top.L1448;

import tool.TreeNode;

class Solution {

    int ans = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    public void dfs(TreeNode root, int max) {

        if(root == null) {
            return;
        }
        // 再找的過程中遇到符合條件的
        if(root.val >= max) {
            ans++;
            // 更新最大值
            max = root.val;
        }

        dfs(root.left, max);
        dfs(root.right, max);
    }
}
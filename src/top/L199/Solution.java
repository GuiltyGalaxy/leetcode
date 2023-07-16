package top.L199;

import tool.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<Integer> ans;

    public List<Integer> rightSideView(TreeNode root) {
        ans = new LinkedList<>();
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (ans.size() == level) {
            ans.add(node.val);
        }

        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }
}
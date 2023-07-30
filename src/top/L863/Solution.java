package top.L863;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<TreeNode> path = new ArrayList<>();

        // 尋找所有target的父節點放入path
        rootToNodePath(root, target, path);

        // 依序把path中的節點找過
        // 原理是target如果是位於level 3
        // 則可以從level 3開始往 level 2、1找
        // 每上升一層dist也+1
        // 然後用這個基準點往下找
        for (int i = 0; i < path.size(); i++) {
            // 停止點會是上個找過的path
            // 也就是path.get(i - 1)
            // 避免重複查找
            // i==0代表為原始起點就不在設置停止點
            kLevelDown(k - i, path.get(i), (i == 0) ? null : path.get(i - 1));
        }

        return ans;
    }

    private boolean rootToNodePath(TreeNode node, TreeNode target, List<TreeNode> path) {

        if (node == null) {
            return false;
        }

        if (node.val == target.val) {
            path.add(target);
            return true;
        }

        // 往下找是否有符合target的節點
        if (rootToNodePath(node.left, target, path) || rootToNodePath(node.right, target, path)) {
            // 有符合代表該節點為target的父節點
            path.add(node);
            return true;
        }

        return false;
    }

    private void kLevelDown(int dist, TreeNode node, TreeNode blocker) {

        // 都為null則停止
        if (node == null && blocker == null) {
            return;
        }

        // node為null代表無法往下找了
        if (node == null) {
            return;
        }

        // 數值相等代表該點重複就不往下找(題目有規定所有節點數值都不可重複)
        if (blocker != null && node.val == blocker.val) {
            return;
        }

        // 距離符合則加入答案中
        if (dist == 0) {
            ans.add(node.val);
            return;
        }

        // 繼續往下找
        kLevelDown(dist - 1, node.left, blocker);
        kLevelDown(dist - 1, node.right, blocker);
    }
}
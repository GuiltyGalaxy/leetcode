package top.L124;

import tool.TreeNode;

public class Solution {
    private int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {

        if (node == null) {
            return 0;
        }
        //起點從最left開始算
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        //更新maxValue
        maxValue = Math.max(maxValue, left + right + node.val);
        //回傳的值會是選擇left跟right的最大值
        //為什麼不回傳left + right + node.val
        //因路徑選擇的限制你只要往上選擇勢必會拋棄另一個路線
        return Math.max(left, right) + node.val;
    }
}
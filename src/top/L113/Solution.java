package top.L113;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return result;
        }

        helper(root, targetSum, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum ,ArrayList<Integer> currSolution) {

        if (root == null) {
            return;
        }

        targetSum -= root.val;
        // 加入當前解答區
        currSolution.add(root.val);

        if (root.left == null && root.right == null) {
            // 找到目標值
            if (targetSum == 0) {
                // 將解答區答案填入
                result.add(new ArrayList<>(currSolution));
            }
        }

        helper(root.left, targetSum, currSolution);
        helper(root.right, targetSum, currSolution);

        // 該值找完移出解答區
        currSolution.remove(currSolution.size() - 1);
    }
}
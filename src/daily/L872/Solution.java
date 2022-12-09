package daily.L872;

import tool.TreeNode;

import java.util.ArrayList;

class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        //中序歷遍
        preorder(root1, one);
        preorder(root2, two);
        return one.equals(two);
    }

    private static void preorder(TreeNode root, ArrayList<Integer> li) {
        //為leaf加入至list中
        if (root.left == null && root.right == null) {
            li.add(root.val);
        }
        if (root.left != null) {
            preorder(root.left, li);
        }
        if (root.right != null) {
            preorder(root.right, li);
        }
    }


}
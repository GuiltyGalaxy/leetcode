package top.L235;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode tree = TreeNode.createTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        TreeNode p = TreeNode.createTree(2, 0, 4, null, null, 3, 5);
        TreeNode q = TreeNode.createTree(4, 3, 5);
        Assertions.assertTrue(TreeNode.isEquals(solution.lowestCommonAncestor(tree, p, q), p));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode tree = TreeNode.createTree(2, 1);
        TreeNode p = TreeNode.createTree(2, 1);
        TreeNode q = TreeNode.createTree(1);
        Assertions.assertTrue(TreeNode.isEquals(solution.lowestCommonAncestor(tree, p, q), p));
    }
}
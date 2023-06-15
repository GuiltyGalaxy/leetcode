package top.L226;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(4, 2, 7, 1, 3, 6, 9);
        TreeNode b = TreeNode.createTree(4, 7, 2, 9, 6, 3, 1);
        Assertions.assertTrue(TreeNode.isEquals(solution.invertTree(a), b));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(2, 1, 3);
        TreeNode b = TreeNode.createTree(2, 3, 1);
        Assertions.assertTrue(TreeNode.isEquals(solution.invertTree(a), b));
    }
}
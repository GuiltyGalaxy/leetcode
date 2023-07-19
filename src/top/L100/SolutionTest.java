package top.L100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(1, 2, 3);
        TreeNode b = TreeNode.createTree(1, 2, 3);
        Assertions.assertTrue(solution.isSameTree(a, b));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(1, 2);
        TreeNode b = TreeNode.createTree(1, null, 2);
        Assertions.assertFalse(solution.isSameTree(a, b));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(1, 2, 1);
        TreeNode b = TreeNode.createTree(1, 1, 2);
        Assertions.assertFalse(solution.isSameTree(a, b));
    }
}
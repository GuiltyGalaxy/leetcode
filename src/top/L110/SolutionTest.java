package top.L110;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(3, 9, 20, null, null, 15, 7);
        Assertions.assertTrue(solution.isBalanced(a));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(1, 2, 2, 3, 3, null, null, 4, 4);
        Assertions.assertFalse(solution.isBalanced(a));
    }
}
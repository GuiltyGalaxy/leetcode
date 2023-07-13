package top.L98;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isValidBST(TreeNode.createTree(2, 1, 3)));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.isValidBST(TreeNode.createTree(5, 1, 4, null, null, 3, 6)));
    }
}
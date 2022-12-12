package top.L124;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxPathSum(TreeNode.createTree(1, 2, 3)), 6);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxPathSum(TreeNode.createTree(-10, 9, 20, null, null, 15, 7)), 42);
    }
}
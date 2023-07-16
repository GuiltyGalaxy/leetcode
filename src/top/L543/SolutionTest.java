package top.L543;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.diameterOfBinaryTree(TreeNode.createTree(1, 2, 3, 4, 5)), 3);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.diameterOfBinaryTree(TreeNode.createTree(1, 2)), 1);
    }
}
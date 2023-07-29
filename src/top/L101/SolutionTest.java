package top.L101;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isSymmetric(TreeNode.createTree(1, 2, 2, 3, 4, 4, 3)));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.isSymmetric(TreeNode.createTree(1, 2, 2, null, 3, null, 3)));
    }

}
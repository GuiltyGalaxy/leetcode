package top.L230;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.kthSmallest(TreeNode.createTree(3, 1, 4, null, 2), 1), 1);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.kthSmallest(TreeNode.createTree(5, 3, 6, 2, 4, null, null, 1), 3), 3);
    }
}
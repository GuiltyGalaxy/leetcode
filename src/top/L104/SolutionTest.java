package top.L104;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxDepth(TreeNode.createTree(3, 9, 20, null, null, 15, 7)), 3);
    }


    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxDepth(TreeNode.createTree(1, null, 2)), 2);
    }
}
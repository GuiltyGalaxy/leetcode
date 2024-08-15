package top.L1448;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode node = TreeNode.createTree(3, 1, 4, 3, null, 1, 5);
        Assertions.assertEquals(4, solution.goodNodes(node));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode node = TreeNode.createTree(3, 3, null, 4, 2);
        Assertions.assertEquals(3, solution.goodNodes(node));
    }

}
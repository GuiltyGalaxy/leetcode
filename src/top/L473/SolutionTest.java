package top.L473;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.pathSum(
                        TreeNode.createTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8)
                , 3);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.pathSum(
                        TreeNode.createTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22)
                , 3);
    }
}
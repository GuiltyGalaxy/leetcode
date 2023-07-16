package top.L199;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode tree = TreeNode.createTree(1, 2, 3, null, 5, null, 4);
        Assertions.assertIterableEquals(solution.rightSideView(tree), List.of(1, 3, 4));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode tree = TreeNode.createTree(1, null, 3);
        Assertions.assertIterableEquals(solution.rightSideView(tree), List.of(1, 3));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.rightSideView(null).size(), 0);
    }
}
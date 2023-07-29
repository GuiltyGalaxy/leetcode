package top.L113;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(
                solution.pathSum(TreeNode.createTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22),
                List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5)));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.pathSum(TreeNode.createTree(1, 2, 3), 5), List.of());
    }
}
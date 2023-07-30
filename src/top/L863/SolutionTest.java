package top.L863;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

import java.util.List;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode target = TreeNode.createTree(5, 6, 2, null, null, 7, 4);
        Assertions.assertIterableEquals(solution.distanceK(root, target, 2), List.of(7, 4, 1));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTree(1);
        TreeNode target = TreeNode.createTree(1);
        Assertions.assertIterableEquals(solution.distanceK(root, target, 3), List.of());
    }

}
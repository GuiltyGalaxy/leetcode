package top.L572;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(3, 4, 5, 1, 2);
        TreeNode b = TreeNode.createTree(4, 1, 2);
        Assertions.assertTrue(solution.isSubtree(a, b));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(3, 4, 5, 1, 2, null, null, null, null, 0);
        TreeNode b = TreeNode.createTree(4, 1, 2);
        Assertions.assertFalse(solution.isSubtree(a, b));
    }
}
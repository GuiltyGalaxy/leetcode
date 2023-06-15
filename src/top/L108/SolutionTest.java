package top.L108;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(0, -10, 5, null, -3, null, 9);
        Assertions.assertTrue(TreeNode.isEquals(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}), a));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(1, null, 3);
        Assertions.assertTrue(TreeNode.isEquals(solution.sortedArrayToBST(new int[]{1, 3}), a));
    }
}
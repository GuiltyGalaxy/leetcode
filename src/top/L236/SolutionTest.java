package top.L236;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = TreeNode.createTree(5, 6, 2, null, null,7, 4);
        TreeNode q = TreeNode.createTree(1, 0, 8);
        Assertions.assertEquals(3, solution.lowestCommonAncestor(a, p, q).val);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = TreeNode.createTree(5, 6, 2, 7, 4);
        TreeNode q = TreeNode.createTree(4);
        Assertions.assertEquals(5, solution.lowestCommonAncestor(a, p, q).val);
    }
}
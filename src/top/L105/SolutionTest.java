package top.L105;

import tool.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(
                TreeNode.isEquals(
                        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}),
                        TreeNode.createTree(3, 9, 20, null, null, 15, 7)));
    }


}
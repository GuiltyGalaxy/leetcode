package top.L662;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.widthOfBinaryTree(TreeNode.createTree(1, 3, 2, 5, 3, null, 9)), 4);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.widthOfBinaryTree(TreeNode.createTree(1, 3, 2, 5, null, null, 9, 6, null, 7)), 7);
    }

}
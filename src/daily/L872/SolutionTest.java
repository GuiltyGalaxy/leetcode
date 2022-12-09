package daily.L872;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode root1 = TreeNode.createTree(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4);
        TreeNode root2 = TreeNode.createTree(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8);
        Assertions.assertTrue(solution.leafSimilar(root1, root2));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode root1 = TreeNode.createTree(1, 2, 3);
        TreeNode root2 = TreeNode.createTree(1, 3, 2);
        Assertions.assertFalse(solution.leafSimilar(root1, root2));
    }

}
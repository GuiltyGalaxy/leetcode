package daily.L1026;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTree(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13);
        Assertions.assertEquals(solution.maxAncestorDiff(root), 7);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTree(1, null, 2, null, 0, 3);
        Assertions.assertEquals(solution.maxAncestorDiff(root), 3);
    }

}
package daily.L222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.countNodes(TreeNode.createTree(1, 2, 3, 4, 5, 6, 7)), 7);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.countNodes(TreeNode.createTree(1, 2, 3, 4, 5, 6)), 6);
    }
}
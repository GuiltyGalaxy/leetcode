package daily.L1339;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxProduct(TreeNode.createTree(1, 2, 3, 4, 5, 6)), 110);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxProduct(TreeNode.createTree(1, null, 2, 3, 4, null, null, 5, 6)), 90);
    }

}
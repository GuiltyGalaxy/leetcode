package daily.L938;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNode.createTree(10, 5, 15, 3, 7, null, 18);
        Assertions.assertEquals(solution.rangeSumBST(treeNode, 7, 15), 32);
    }
}
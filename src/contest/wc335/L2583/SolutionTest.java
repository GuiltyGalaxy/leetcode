package contest.wc335.L2583;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNode.createTree(5, 8, 9, 2, 1, 3, 7, 4, 6);
        Assertions.assertEquals(solution.kthLargestLevelSum(treeNode, 2), 13);
    }

}
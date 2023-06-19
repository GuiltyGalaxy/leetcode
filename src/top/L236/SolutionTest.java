package top.L236;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(3,5,1,6,2,0,8,null,null,7,4);
        TreeNode p = TreeNode.createTree(5,6,2,7,4);
        TreeNode q = TreeNode.createTree(2,7,4);
        Assertions.assertTrue(TreeNode.isEquals(solution.lowestCommonAncestor(a,p,q),p));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(3,5,1,6,2,0,8,null,null,7,4);
        TreeNode p = TreeNode.createTree(5,6,2,7,4);
        TreeNode q = TreeNode.createTree(4);
        Assertions.assertTrue(TreeNode.isEquals(solution.lowestCommonAncestor(a,p,q),p));
    }
}
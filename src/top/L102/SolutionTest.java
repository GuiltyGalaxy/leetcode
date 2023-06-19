package top.L102;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(3));
        ans.add(List.of(9, 20));
        ans.add(List.of(15, 7));
        Assertions.assertIterableEquals(solution.levelOrder(a), ans);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        TreeNode a = TreeNode.createTree(1);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(1));
        Assertions.assertIterableEquals(solution.levelOrder(a), ans);
    }
}
package top.L40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(List.of(1, 1, 6));
        ans.add(List.of(1, 2, 5));
        ans.add(List.of(1, 7));
        ans.add(List.of(2, 6));
        Assertions.assertIterableEquals(ans, solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

}
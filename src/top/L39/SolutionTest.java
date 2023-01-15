package top.L39;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(List.of(7));
        ans.add(List.of(2, 2, 3));
        Assertions.assertIterableEquals(solution.combinationSum(new int[]{2, 3, 6, 7}, 7), ans);
    }

}
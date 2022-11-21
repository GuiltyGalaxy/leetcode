package top.L18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = Arrays.asList(0, 0, 0, 1000000000);
        ans.add(a);
        Assertions.assertIterableEquals(solution.fourSum(
                        new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000),
                ans);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = Arrays.asList(2,2,2,2);
        ans.add(a);
        Assertions.assertIterableEquals(solution.fourSum(
                        new int[]{2,2,2,2,2}, 8),
                ans);
    }
}
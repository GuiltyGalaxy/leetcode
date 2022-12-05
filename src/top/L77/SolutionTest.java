package top.L77;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(1, 2));
        ans.add(List.of(1, 3));
        ans.add(List.of(1, 4));
        ans.add(List.of(2, 3));
        ans.add(List.of(2, 4));
        ans.add(List.of(3, 4));
        Assertions.assertIterableEquals(solution.combine(4, 2), ans);
    }
}
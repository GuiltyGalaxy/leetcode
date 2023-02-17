package top.L336;

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
        ans.add(Arrays.asList(0, 1));
        ans.add(Arrays.asList(1, 0));
        ans.add(Arrays.asList(3, 2));
        ans.add(Arrays.asList(2, 4));
        Assertions.assertIterableEquals(solution.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}), ans);
    }

}
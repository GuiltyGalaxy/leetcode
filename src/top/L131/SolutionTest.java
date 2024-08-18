package top.L131;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<String>> ans = new ArrayList<>();
        ans.add(Arrays.asList("a", "a", "b"));
        ans.add(Arrays.asList("aa", "b"));
        Assertions.assertEquals(ans, solution.partition("aab"));
    }
}
package top.L438;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.findAnagrams("cbaebabacd", "abc"), Arrays.asList(0, 6));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.findAnagrams("abab", "ab"), Arrays.asList(0, 1, 2));
    }
}
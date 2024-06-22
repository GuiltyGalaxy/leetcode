package top.L139;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.wordBreak("leetcode", List.of("leet", "code")));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertTrue(solution.wordBreak("applepenapple", List.of("apple", "pen")));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertFalse(solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
package top.L318;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}), 16);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}), 4);
    }
}
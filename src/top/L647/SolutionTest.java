package top.L647;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.countSubstrings("abc"));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(6, solution.countSubstrings("aaa"));
    }
}
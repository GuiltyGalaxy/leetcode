package leetcode.L2131;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}), 8);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestPalindrome(new String[]{"cc", "ll", "xx"}), 2);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestPalindrome(
                new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"})
                , 22);
    }

    @Test
    public void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestPalindrome(
                        new String[]{"em","pe","mp","ee","pp","me","ep","em","em","me"})
                , 14);
    }
}
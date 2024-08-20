package top.L5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals("aba", solution.longestPalindrome("cabad"));
        Assertions.assertEquals("aba", solution.longestPalindrome2("cabad"));
        Assertions.assertEquals("aba", solution.longestPalindrome3("cabad"));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals("bb", solution.longestPalindrome("cbbd"));
        Assertions.assertEquals("bb", solution.longestPalindrome2("cbbd"));
        Assertions.assertEquals("bb", solution.longestPalindrome3("cbbd"));
    }


    @Test
    public void case3() {
        Solution solution = new Solution();
        // abcdcbabcdxdcbabcdxdcb
        //    -------*-------
        Assertions.assertEquals("dcbabcdxdcbabcd", solution.longestPalindrome("abcdcbabcdxdcbabcdxdcb"));
        Assertions.assertEquals("dcbabcdxdcbabcd", solution.longestPalindrome2("abcdcbabcdxdcbabcdxdcb"));
        Assertions.assertEquals("dcbabcdxdcbabcd", solution.longestPalindrome3("abcdcbabcdxdcbabcdxdcb"));
    }

}
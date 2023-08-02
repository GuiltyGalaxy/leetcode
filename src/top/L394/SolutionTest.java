package top.L394;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.decodeString("3[a]2[bc]"), "aaabcbc");
        Assertions.assertEquals(solution.decodeString2("3[a]2[bc]"), "aaabcbc");
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.decodeString("3[a2[c]]"), "accaccacc");
        Assertions.assertEquals(solution.decodeString2("3[a2[c]]"), "accaccacc");
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.decodeString("2[abc]3[cd]ef"), "abcabccdcdcdef");
        Assertions.assertEquals(solution.decodeString2("2[abc]3[cd]ef"), "abcabccdcdcdef");
    }
}
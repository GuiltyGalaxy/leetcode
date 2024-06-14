package top.L191;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int ans = solution.hammingWeight(11);
        Assertions.assertEquals(3, ans);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        int ans = solution.hammingWeight(128);
        Assertions.assertEquals(1, ans);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        int ans = solution.hammingWeight(2147483645);
        Assertions.assertEquals(30, ans);
    }
}
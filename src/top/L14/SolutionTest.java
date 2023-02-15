package top.L14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl");
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "");
    }
}
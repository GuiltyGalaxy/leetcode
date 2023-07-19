package top.L1046;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}), 1);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.lastStoneWeight(new int[]{1}), 1);
    }
}
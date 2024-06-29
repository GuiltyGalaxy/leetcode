package top.L525;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.findMaxLength(new int[]{0, 1}));
        Assertions.assertEquals(2, solution.findMaxLength2(new int[]{0, 1}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.findMaxLength(new int[]{0, 1, 0}));
        Assertions.assertEquals(2, solution.findMaxLength2(new int[]{0, 1, 0}));
    }
}
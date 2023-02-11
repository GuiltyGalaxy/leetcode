package top.L283;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int[] ans = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(ans);
        Assertions.assertArrayEquals(ans, new int[]{1, 3, 12, 0, 0});
    }
}
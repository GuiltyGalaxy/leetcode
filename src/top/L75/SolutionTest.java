package top.L75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int[] ans = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(ans);
        Assertions.assertArrayEquals(ans, new int[]{0, 0, 1, 1, 2, 2});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        int[] ans = new int[]{2, 1, 0};
        solution.sortColors(ans);
        Assertions.assertArrayEquals(ans, new int[]{0, 1, 2});
    }

}
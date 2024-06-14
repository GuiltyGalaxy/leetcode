package top.L338;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{0, 1, 1}, solution.countBits(2));
        Assertions.assertArrayEquals(new int[]{0, 1, 1}, solution.countBits2(2));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, solution.countBits(5));
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, solution.countBits2(5));
    }

}
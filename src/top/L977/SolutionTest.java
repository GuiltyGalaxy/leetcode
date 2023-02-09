package top.L977;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.sortedSquares(new int[]{-4, -1, 0, 3, 10}), new int[]{0, 1, 9, 16, 100});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.sortedSquares(new int[]{-7, -3, 2, 3, 11}), new int[]{4, 9, 9, 49, 121});
    }
}
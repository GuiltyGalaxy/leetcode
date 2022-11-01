package leetcode.L1706;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(
                solution.findBall(new int[][]{
                        {1, 1, 1, -1, -1},
                        {1, 1, 1, -1, -1},
                        {-1, -1, -1, 1, 1},
                        {1, 1, 1, 1, -1},
                        {-1, -1, -1, -1, -1}
                }), new int[]{1, -1, -1, -1, -1});

    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(
                solution.findBall(new int[][]{
                        {1, 1, 1, 1, 1, 1},
                        {-1, -1, -1, -1, -1, -1},
                        {1, 1, 1, 1, 1, 1},
                        {-1, -1, -1, -1, -1, -1}
                }), new int[]{0, 1, 2, 3, 4, -1});
    }

}
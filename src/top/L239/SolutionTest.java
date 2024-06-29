package top.L239;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7},
                solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        Assertions.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7},
                solution.maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

}
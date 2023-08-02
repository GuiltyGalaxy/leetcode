package top.L735;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.asteroidCollision(new int[]{5, 10, -5}), new int[]{5, 10});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.asteroidCollision(new int[]{8, -8}), new int[]{});
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.asteroidCollision(new int[]{10, 2, -5}), new int[]{10});
    }
}
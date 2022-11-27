package top.L503;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.nextGreaterElements(new int[]{1, 2, 1}), new int[]{2, -1, 2});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.nextGreaterElements(new int[]{1, 2, 3, 4, 3}), new int[]{2, 3, 4, -1, 4});
    }
}
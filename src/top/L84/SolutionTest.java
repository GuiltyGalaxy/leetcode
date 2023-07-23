package top.L84;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}), 10);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.largestRectangleArea(new int[]{2, 4}), 4);
    }
}
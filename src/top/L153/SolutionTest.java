package top.L153;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}), 0);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findMin(new int[]{11, 13, 15, 17}), 11);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findMin(new int[]{1, 2, 4, 5, 6, 7, 0}), 0);
    }

    @Test
    public void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findMin(new int[]{3, 1, 2}), 1);
    }
}
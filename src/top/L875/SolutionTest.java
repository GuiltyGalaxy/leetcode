package top.L875;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8), 4);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5), 30);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6), 23);
    }
}
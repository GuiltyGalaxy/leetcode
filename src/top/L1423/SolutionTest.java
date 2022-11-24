package top.L1423;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3), 12);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxScore(new int[]{2, 2, 2}, 2), 4);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7), 55);
    }
}
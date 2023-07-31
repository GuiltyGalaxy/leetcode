package top.L41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.firstMissingPositive(new int[]{1, 2, 0}), 3);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.firstMissingPositive(new int[]{3, 4, -1, 1}), 2);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}), 1);
    }
}
package top.L1658;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.minOperations(new int[]{1, 1, 4, 2, 3}, 5), 2);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.minOperations(new int[]{5, 6, 7, 8, 9}, 4), -1);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10), 5);
    }
}
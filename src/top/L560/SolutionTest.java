package top.L560;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.subarraySum(new int[]{1, 1, 1}, 2), 2);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.subarraySum(new int[]{1, 2, 3}, 3), 2);
    }
}
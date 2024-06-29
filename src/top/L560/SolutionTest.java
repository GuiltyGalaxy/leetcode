package top.L560;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.subarraySum(new int[]{1, 1, 1}, 2));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
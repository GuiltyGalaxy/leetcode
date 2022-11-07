package wc318.L2461;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3), 8);
    }

}
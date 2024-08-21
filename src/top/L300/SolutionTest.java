package top.L300;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        Assertions.assertEquals(4, solution.lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        Assertions.assertEquals(4, solution.lengthOfLIS2(new int[]{0, 1, 0, 3, 2, 3}));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        Assertions.assertEquals(1, solution.lengthOfLIS2(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    @Test
    public void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(5, solution.lengthOfLIS(new int[]{0, 1, 2, 3, 1, 2, 5, 1}));
        Assertions.assertEquals(5, solution.lengthOfLIS2(new int[]{0, 1, 2, 3, 1, 2, 5, 1}));
    }
}
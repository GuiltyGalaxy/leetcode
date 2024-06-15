package top.L377;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(7, solution.combinationSum4(new int[]{1, 2, 3}, 4));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(0, solution.combinationSum4(new int[]{9}, 3));
    }

}
package top.L121;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
    }

}
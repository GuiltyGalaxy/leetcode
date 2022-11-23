package top.L540;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}), 2);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}), 10);
    }
}
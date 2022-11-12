package top.L287;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findDuplicate(new int[]{1, 2, 4, 3, 2}), 2);
    }
}
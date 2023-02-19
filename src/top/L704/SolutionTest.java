package top.L704;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9), 4);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.search(new int[]{12}, 12), 0);
    }
}
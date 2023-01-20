package top.L16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1), 2);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.threeSumClosest(new int[]{0, 0, 0}, 1), 0);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.threeSumClosest(new int[]{1, 1, 1, 1}, 3), 3);
    }
}
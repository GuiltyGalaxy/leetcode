package top.L547;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}), 2);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}), 3);
    }
}
package leetcode.L1293;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.shortestPath(new int[][]{{0,0,0}, {1,1,0}, {0,0,0},{0,1,1},{0,0,0}},1),6);
    }
}
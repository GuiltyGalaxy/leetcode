package top.L347;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2), new int[]{1, 2});
    }

}
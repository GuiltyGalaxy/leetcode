package top.L33;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0), 4);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), -1);
    }

}
package top.L1300;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findBestValue(new int[]{4, 9, 3}, 10), 3);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findBestValue(new int[]{2, 3, 5}, 10), 5);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803), 11361);
    }
}
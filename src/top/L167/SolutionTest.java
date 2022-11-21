package top.L167;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(solution.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2});
    }
}
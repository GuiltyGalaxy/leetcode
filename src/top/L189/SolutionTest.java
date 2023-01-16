package top.L189;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int[] ans = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(ans, 3);
        Assertions.assertArrayEquals(ans, new int[]{5, 6, 7, 1, 2, 3, 4});
    }

}
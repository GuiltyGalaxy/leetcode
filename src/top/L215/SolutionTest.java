package top.L215;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(5, solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        Assertions.assertEquals(5, solution.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(4, solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        Assertions.assertEquals(4, solution.findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
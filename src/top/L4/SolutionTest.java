package top.L4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 2.0);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 2.5);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6}), 3.5);
    }

    @Test
    public void case4() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.findMedianSortedArrays(new int[]{1}, new int[]{4}), 2.5);
    }
}
package top.L324;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int[] in = new int[]{1, 5, 1, 1, 6, 4};
        solution.wiggleSort(in);
        Assertions.assertArrayEquals(in, new int[]{1, 6, 1, 5, 1, 4});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        int[] in = new int[]{1, 5, 1, 1, 6};
        solution.wiggleSort(in);
        Assertions.assertArrayEquals(in, new int[]{1, 6, 1, 5, 1});
    }
}
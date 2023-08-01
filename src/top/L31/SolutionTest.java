package top.L31;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int[] in = new int[]{1, 2, 3};
        solution.nextPermutation(in);
        Assertions.assertArrayEquals(in, new int[]{1, 3, 2});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        int[] in = new int[]{3, 2, 1};
        solution.nextPermutation(in);
        Assertions.assertArrayEquals(in, new int[]{1, 2, 3});
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        int[] in = new int[]{1, 1, 5};
        solution.nextPermutation(in);
        Assertions.assertArrayEquals(in, new int[]{1, 5, 1});
    }

}
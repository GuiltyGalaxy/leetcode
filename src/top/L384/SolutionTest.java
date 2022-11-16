package top.L384;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        int[] in = new int[]{1, 2, 3};
        Solution solution = new Solution(in);
        solution.shuffle();
        Assertions.assertArrayEquals(solution.reset(), in);
        solution.shuffle();
    }

}
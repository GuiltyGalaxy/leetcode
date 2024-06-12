package top.L268;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.missingNumber1(new int[]{3, 0, 1}));
        Assertions.assertEquals(2, solution.missingNumber2(new int[]{3, 0, 1}));
        Assertions.assertEquals(2, solution.missingNumber3(new int[]{3, 0, 1}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.missingNumber1(new int[]{0, 1}));
        Assertions.assertEquals(2, solution.missingNumber2(new int[]{0, 1}));
        Assertions.assertEquals(2, solution.missingNumber3(new int[]{0, 1}));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(8, solution.missingNumber1(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        Assertions.assertEquals(8, solution.missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        Assertions.assertEquals(8, solution.missingNumber3(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
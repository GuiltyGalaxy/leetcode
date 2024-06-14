package top.L287;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.findDuplicate(new int[]{1, 2, 4, 3, 2}));
        Assertions.assertEquals(2, solution.findDuplicate2(new int[]{1, 2, 4, 3, 2}));
        Assertions.assertEquals(2, solution.findDuplicate3(new int[]{1, 2, 4, 3, 2}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
        Assertions.assertEquals(3, solution.findDuplicate2(new int[]{3, 1, 3, 4, 2}));
        Assertions.assertEquals(3, solution.findDuplicate3(new int[]{3, 1, 3, 4, 2}));
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.findDuplicate(new int[]{3, 3, 3, 3, 3}));
        Assertions.assertEquals(3, solution.findDuplicate2(new int[]{3, 3, 3, 3, 3}));
        Assertions.assertEquals(3, solution.findDuplicate3(new int[]{3, 3, 3, 3, 3}));
    }
}
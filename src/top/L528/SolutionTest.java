package top.L528;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        //隨機機率沒想到好測法
        Solution solution = new Solution(new int[]{1, 3});
        Assertions.assertEquals(solution.pickIndex(), 1);
    }

}
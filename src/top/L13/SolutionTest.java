package top.L13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.romanToInt("III"), 3);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.romanToInt("LVIII"), 58);
    }


    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.romanToInt("MCMXCIV"), 1994);
    }
}
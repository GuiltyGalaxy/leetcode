package daily.L345;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.reverseVowels("hello"), "holle");
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.reverseVowels("daily"), "leotcede");
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.reverseVowels("aA"), "Aa");
    }
}
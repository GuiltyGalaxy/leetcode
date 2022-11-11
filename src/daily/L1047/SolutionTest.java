package daily.L1047;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.removeDuplicates("abbaca"), "ca");
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.removeDuplicates("azxxzy"), "ay");
    }

}
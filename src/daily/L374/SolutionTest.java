package daily.L374;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {

        Solution solution = new Solution(6);
        Assertions.assertEquals(solution.guessNumber(10), 6);
    }

}
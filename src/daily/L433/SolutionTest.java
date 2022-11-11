package daily.L433;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(
                solution.minMutation(
                        "AACCGGTT",
                        "AACCGGTA",
                        new String[]{"AACCGGTA"})
                , 1);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(
                solution.minMutation(
                        "AACCGGTT",
                        "AAACGGTA",
                        new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"})
                , 2);
    }

    @Test
    public void case3() {
        Solution solution = new Solution();
        Assertions.assertEquals(
                solution.minMutation(
                        "AACCGGTT",
                        "AACCGCTA",
                        new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"})
                , 2);
    }
}
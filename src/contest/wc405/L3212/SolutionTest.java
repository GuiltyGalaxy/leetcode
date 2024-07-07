package contest.wc405.L3212;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.numberOfSubmatrices(new char[][]{{'X', 'Y', '.'}, {'Y', '.', '.'}}));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.numberOfSubmatrices(new char[][]{{'.', 'X'}, {'.', 'Y'}}));
    }

}
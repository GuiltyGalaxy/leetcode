package top.L51;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.solveNQueens(4),
                List.of(
                        List.of(
                                "..Q.",
                                "Q...",
                                "...Q",
                                ".Q.."
                        ),
                        List.of(
                                ".Q..",
                                "...Q",
                                "Q...",
                                "..Q."
                        )
                ));
    }


}
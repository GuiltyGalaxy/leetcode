package top.L78;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.subsets(new int[]{1, 2, 3}), List.of(
                List.of(),
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 3),
                List.of(1, 3),
                List.of(2),
                List.of(2, 3),
                List.of(3)
        ));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertIterableEquals(solution.subsets(new int[]{0}), List.of(
                List.of(),
                List.of(0)
        ));
    }
}
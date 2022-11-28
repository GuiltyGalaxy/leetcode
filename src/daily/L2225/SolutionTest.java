package daily.L2225;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1, 2, 10));
        list.add(List.of(4, 5, 7, 8));
        Assertions.assertIterableEquals(solution.findWinners(
                        new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}})
                , list);
    }

}
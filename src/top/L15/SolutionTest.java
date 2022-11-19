package top.L15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> a = new ArrayList<>();
        a.add(Arrays.asList(-1, -1, 2));
        a.add(Arrays.asList(-1, 0, 1));
        Assertions.assertIterableEquals(list, a);
    }

}
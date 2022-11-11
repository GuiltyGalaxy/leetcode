package daily.L26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        int[] in = new int[]{1,1,2};
        Assertions.assertEquals(solution.removeDuplicates(in), 2);
        Assertions.assertArrayEquals(Arrays.copyOf(in,2),new int[]{1,2});
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        int[] in = new int[]{0,0,1,1,1,2,2,3,3,4};
        Assertions.assertEquals(solution.removeDuplicates(in), 5);
        Assertions.assertArrayEquals(Arrays.copyOf(in,5),new int[]{0,1,2,3,4});
    }
}
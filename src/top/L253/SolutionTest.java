package top.L253;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(2, solution.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
    }
}
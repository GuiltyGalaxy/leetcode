package top.L759;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        List<Interval> freeTimes = solution.employeeFreeTime(List.of(
                List.of(new Interval(1, 2), new Interval(5, 6)),
                List.of(new Interval(1, 3), new Interval(4, 10))
        ));

        List<Interval> expected = List.of(new Interval(3, 4));

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).start, freeTimes.get(i).start);
            Assertions.assertEquals(expected.get(i).end, freeTimes.get(i).end);
        }
    }

    @Test
    public void case2() {
        Solution solution = new Solution();

        List<Interval> freeTimes = solution.employeeFreeTime(List.of(
                List.of(new Interval(1, 3), new Interval(6, 7)),
                List.of(new Interval(2, 4)),
                List.of(new Interval(2, 5), new Interval(9, 12))
        ));

        List<Interval> expected = List.of(new Interval(5, 6), new Interval(7, 9));

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).start, freeTimes.get(i).start);
            Assertions.assertEquals(expected.get(i).end, freeTimes.get(i).end);
        }
    }
}
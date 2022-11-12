package daily.L295;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MedianFinderTest {
    @Test
    public void case1() {
        MedianFinder solution = new MedianFinder();
        solution.addNum(1);
        solution.addNum(2);
        Assertions.assertEquals(solution.findMedian(), 1.5);
        solution.addNum(3);
        Assertions.assertEquals(solution.findMedian(), 2.0);
    }

}
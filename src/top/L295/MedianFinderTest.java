package top.L295;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MedianFinderTest {
    @Test
    public void case1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        Assertions.assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);    // arr[1, 2, 3]
        Assertions.assertEquals(2, medianFinder.findMedian());
    }

}
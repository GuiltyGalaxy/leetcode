package top.L703;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KthLargestTest {
    @Test
    public void case1() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        Assertions.assertEquals(kthLargest.add(3), 4);
        Assertions.assertEquals(kthLargest.add(5), 5);
        Assertions.assertEquals(kthLargest.add(10), 5);
        Assertions.assertEquals(kthLargest.add(9), 8);
        Assertions.assertEquals(kthLargest.add(4), 8);
    }

}
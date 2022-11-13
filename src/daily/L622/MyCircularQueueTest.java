package daily.L622;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCircularQueueTest {
    @Test
    public void case1() {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);

        Assertions.assertTrue(myCircularQueue.enQueue(1));
        Assertions.assertTrue(myCircularQueue.enQueue(2));
        Assertions.assertTrue(myCircularQueue.enQueue(3));
        Assertions.assertFalse(myCircularQueue.enQueue(4));
        Assertions.assertEquals(myCircularQueue.Rear(), 3);
        Assertions.assertTrue(myCircularQueue.isFull());
        Assertions.assertTrue(myCircularQueue.deQueue());
        Assertions.assertTrue(myCircularQueue.enQueue(4));
        Assertions.assertEquals(myCircularQueue.Rear(), 4);
    }
}
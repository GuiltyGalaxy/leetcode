package top.L155;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinStackTest {
    @Test
    public void case1() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(minStack.getMin(), -3);
        minStack.pop();
        Assertions.assertEquals(minStack.top(), 0);
        Assertions.assertEquals(minStack.getMin(), -2);
    }

}
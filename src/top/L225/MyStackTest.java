package top.L225;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyStackTest {
    @Test
    public void case1() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        Assertions.assertEquals(myStack.top(), 2);
        Assertions.assertEquals(myStack.pop(), 2);
        Assertions.assertFalse(myStack.empty());
    }
}
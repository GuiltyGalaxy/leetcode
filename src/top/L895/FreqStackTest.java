package top.L895;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FreqStackTest {

    @Test
    public void case1() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        Assertions.assertEquals(freqStack.pop(),5);
        Assertions.assertEquals(freqStack.pop(),7);
        Assertions.assertEquals(freqStack.pop(),5);
        Assertions.assertEquals(freqStack.pop(),4);
    }
}
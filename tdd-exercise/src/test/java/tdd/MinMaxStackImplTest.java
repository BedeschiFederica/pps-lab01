package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    @Test
    public void isInitiallyEmpty() {
        MinMaxStack stack = new MinMaxStackImpl();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void canPushAndPeek() {
        MinMaxStack stack = new MinMaxStackImpl();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
    }

}
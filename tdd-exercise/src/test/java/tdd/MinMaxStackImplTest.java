package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {


    public static final int FIRST_VALUE = 1;
    public static final int SECOND_VALUE = 2;

    MinMaxStack stack;

    @BeforeEach
    public void beforeEach() {
        this.stack = new MinMaxStackImpl();
    }

    @Test
    public void isInitiallyEmpty() {
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void IsNotEmptyAfterPush() {
        this.stack.push(FIRST_VALUE);
        assertFalse(this.stack.isEmpty());
    }

    @Test
    public void canPushAndPeek() {
        this.stack.push(FIRST_VALUE);
        this.stack.push(SECOND_VALUE);
        assertEquals(SECOND_VALUE, this.stack.peek());
    }

    @Test
    public void cantPeekIfEmpty() {
        assertThrows(IllegalStateException.class, () -> this.stack.peek());
    }

}
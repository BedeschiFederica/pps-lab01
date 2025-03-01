package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {


    public static final int FIRST_VALUE = 10;
    public static final int SECOND_VALUE = 5;
    public static final int THIRD_VALUE = 8;
    public static final int EXPECTED_SIZE = 2;

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

    private void pushThreeValues() {
        this.stack.push(FIRST_VALUE);
        this.stack.push(SECOND_VALUE);
        this.stack.push(THIRD_VALUE);
    }

    @Test
    public void canPushAndPeek() {
        pushThreeValues();
        assertEquals(THIRD_VALUE, this.stack.peek());
    }

    @Test
    public void cantPeekIfEmpty() {
        assertThrows(IllegalStateException.class, () -> this.stack.peek());
    }

    @Test
    public void canPushAndPop() {
        pushThreeValues();
        assertAll(
                () -> {
                    assertEquals(THIRD_VALUE, this.stack.pop());
                    assertEquals(SECOND_VALUE, this.stack.peek());
                }
        );
    }

    @Test
    public void cantPopIfEmpty() {
        assertThrows(IllegalStateException.class, () -> this.stack.pop());
    }

    @Test
    public void getCorrectSize() {
        pushThreeValues();
        this.stack.pop();
        assertEquals(EXPECTED_SIZE, this.stack.size());
    }

    @Test
    public void getCorrectMinValue() {
        pushThreeValues();
        assertEquals(Collections.min(Arrays.asList(FIRST_VALUE, SECOND_VALUE, THIRD_VALUE)), this.stack.getMin());
    }

}
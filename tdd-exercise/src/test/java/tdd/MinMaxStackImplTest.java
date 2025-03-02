package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private static final List<Integer> VALUES = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 6;
    private static final int N_POPS = 2;

    private MinMaxStack stack;

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
        this.stack.push(VALUES.get(0));
        assertFalse(this.stack.isEmpty());
    }

    private void pushValues() {
        for (Integer value: VALUES) {
            this.stack.push(value);
        }
    }

    @Test
    public void canPushAndPeek() {
        pushValues();
        assertEquals(VALUES.get(VALUES.size() - 1), this.stack.peek());
    }

    @Test
    public void cantPeekIfEmpty() {
        assertThrows(IllegalStateException.class, () -> this.stack.peek());
    }

    @Test
    public void canPushAndPop() {
        pushValues();
        assertAll(
                () -> {
                    assertEquals(VALUES.get(VALUES.size() - 1), this.stack.pop());
                    assertEquals(VALUES.get(VALUES.size() - 2), this.stack.peek());
                }
        );
    }

    @Test
    public void cantPopIfEmpty() {
        assertThrows(IllegalStateException.class, () -> this.stack.pop());
    }

    @Test
    public void getCorrectSize() {
        pushValues();
        for (int i = 0; i < N_POPS; i++) {
            this.stack.pop();
        }
        assertEquals(VALUES.size() - N_POPS, this.stack.size());
    }

    @Test
    public void getCorrectMinValueAfterPush() {
        pushValues();
        this.stack.push(MIN_VALUE);
        this.stack.push(MAX_VALUE);
        assertEquals(MIN_VALUE, this.stack.getMin());
    }

    @Test
    public void getCorrectMinValueAfterPoppingTheMin() {
        pushValues();
        this.stack.push(MIN_VALUE);
        this.stack.push(MAX_VALUE);
        this.stack.pop();
        this.stack.pop();
        assertEquals(Collections.min(VALUES), this.stack.getMin());
    }

    @Test
    public void cantGetMinValueIfEmpty() {
        assertThrows(IllegalStateException.class, () -> this.stack.getMin());
    }

    @Test
    public void getCorrectMaxValueAfterPush() {
        pushValues();
        this.stack.push(MAX_VALUE);
        this.stack.push(MIN_VALUE);
        assertEquals(MAX_VALUE, this.stack.getMax());
    }

    @Test
    public void getCorrectMaxValueAfterPoppingTheMax() {
        pushValues();
        this.stack.push(MAX_VALUE);
        this.stack.push(MIN_VALUE);
        this.stack.pop();
        this.stack.pop();
        assertEquals(Collections.max(VALUES), this.stack.getMax());
    }

}
package tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final List<Integer> VALUES = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final int MAX_SIZE = 3;
    private static final int START = 0;
    private static final int N_REMOVE = 2;

    private CircularQueue circularQueue;

    @BeforeEach
    public void beforeEach() {
        this.circularQueue = new CircularQueueImpl(MAX_SIZE);
    }

    @Test
    public void isInitiallyEmpty() {
        assertTrue(this.circularQueue.isEmpty());
    }

    @Test
    public void isNotEmptyAfterAdd() {
        this.circularQueue.add(VALUES.get(START));
        assertFalse(this.circularQueue.isEmpty());
    }

    private void addMaxSizeValues(final int from) {
        for (int i = from; i < from + MAX_SIZE; i++) {
            this.circularQueue.add(VALUES.get(i));
        }
    }

    @Test
    public void getMaxSize() {
        assertEquals(MAX_SIZE, this.circularQueue.getMaxSize());
    }

    @Test
    public void canAddAndPeek() {
        addMaxSizeValues(START);
        assertEquals(VALUES.get(START), this.circularQueue.peek());
    }

    @Test
    public void cantPeekIfEmpty() {
        assertThrows(IllegalStateException.class, () -> this.circularQueue.peek());
    }

    @Test
    public void canAddAndRemove() {
        addMaxSizeValues(START);
        assertAll(
                () -> {
                    assertEquals(VALUES.get(START), this.circularQueue.remove());
                    assertEquals(VALUES.get(START + 1), this.circularQueue.peek());
                }
        );
    }

    @Test
    public void cantRemoveIfEmpty() {
        assertThrows(IllegalStateException.class, () -> this.circularQueue.remove());
    }

    @Test
    public void getCorrectCurrentSize() {
        addMaxSizeValues(START);
        for (int i = 0; i < N_REMOVE; i++) {
            this.circularQueue.remove();
        }
        assertEquals(MAX_SIZE - N_REMOVE, this.circularQueue.getCurrentSize());
    }

    @Test
    public void canOverflow() {
        addMaxSizeValues(START);
        this.circularQueue.add(VALUES.get(MAX_SIZE));
        assertEquals(VALUES.get(START + 1), this.circularQueue.peek());
    }

    @Test
    public void canRemoveWhenOverflowed() {
        addMaxSizeValues(START);
        this.circularQueue.add(VALUES.get(MAX_SIZE));
        assertAll(
                () -> {
                    assertEquals(VALUES.get(START + 1), this.circularQueue.remove());
                    assertEquals(VALUES.get(START + 2), this.circularQueue.peek());
                }
        );
    }

}

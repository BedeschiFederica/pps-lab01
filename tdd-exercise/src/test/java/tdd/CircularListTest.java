package tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final List<Integer> VALUES = new ArrayList<>(Arrays.asList(1, 2, 3));
    private static final int MAX_SIZE = 3;
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
        this.circularQueue.add(VALUES.get(0));
        assertFalse(this.circularQueue.isEmpty());
    }

    private void addValues() {
        for (Integer value: VALUES) {
            this.circularQueue.add(value);
        }
    }

    @Test
    public void getMaxSize() {
        assertEquals(MAX_SIZE, this.circularQueue.getMaxSize());
    }

    @Test
    public void canAddAndPeek() {
        addValues();
        assertEquals(VALUES.get(0), this.circularQueue.peek());
    }

    @Test
    public void cantPeekIfEmpty() {
        assertThrows(IllegalStateException.class, () -> this.circularQueue.peek());
    }

    @Test
    public void canAddAndRemove() {
        addValues();
        assertAll(
                () -> {
                    assertEquals(VALUES.get(0), this.circularQueue.remove());
                    assertEquals(VALUES.get(1), this.circularQueue.peek());
                }
        );
    }

    @Test
    public void cantRemoveIfEmpty() {
        assertThrows(IllegalStateException.class, () -> this.circularQueue.remove());
    }

    @Test
    public void getCorrectCurrentSize() {
        addValues();
        for (int i = 0; i < N_REMOVE; i++) {
            this.circularQueue.remove();
        }
        assertEquals(VALUES.size() - N_REMOVE, this.circularQueue.getCurrentSize());
    }



}

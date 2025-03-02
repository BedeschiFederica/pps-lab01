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

    private static final List<Integer> VALUES = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    private static final int MAX_SIZE = 3;

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

    @Test
    public void getMaxSize() {
        assertEquals(MAX_SIZE, this.circularQueue.getMaxSize());
    }

    @Test
    public void canAddAndPeek() {
        this.circularQueue.add(VALUES.get(0));
        assertEquals(VALUES.get(0), this.circularQueue.peek());
    }

}

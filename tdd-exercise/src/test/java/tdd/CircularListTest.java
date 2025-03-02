package tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    @Test
    public void isInitiallyEmpty() {
        CircularQueue circularQueue = new CircularQueueImpl();
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    public void isNotEmptyAfterAdd() {
        CircularQueue circularQueue = new CircularQueueImpl();
        circularQueue.add(1);
        assertFalse(circularQueue.isEmpty());
    }

}

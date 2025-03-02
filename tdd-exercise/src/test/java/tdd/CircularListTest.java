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
}

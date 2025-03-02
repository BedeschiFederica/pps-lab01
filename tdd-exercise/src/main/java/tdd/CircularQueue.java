package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Checks if the circular queue is empty.
     *
     * @return true if the circular queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Adds an integer to the circular queue.
     *
     * @param value The integer to add
     */
    void add(int value);

    /**
     * Gets the maximum size of the circular queue.
     *
     * @return The maximum size of the circular queue.
     */
    int getMaxSize();

    /**
     * Retrieves, but does not remove, the first element of the circular queue.
     *
     * @return The first element of the circular queue.
     * @throws IllegalStateException if the circular queue is empty.
     */
    int peek();

    /**
     * Removes and returns the first element of the circular queue.
     *
     * @return The removed element.
     * @throws IllegalStateException if the circular queue is empty.
     */
    int remove();

    /**
     * Gets the current size of the circular queue.
     *
     * @return The current size of the circular queue.
     */
    int getCurrentSize();

}
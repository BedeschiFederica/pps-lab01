package tdd;

import java.util.List;
import java.util.ArrayList;

public class CircularQueueImpl implements CircularQueue {

    private final List<Integer> circularQueue = new ArrayList<>();
    private final int maxSize;
    private int currentSize = 0;
    private int firstIndex;

    public CircularQueueImpl(final int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public void add(final int value) {
        this.circularQueue.add(value);
        this.currentSize++;
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }

    private void checkIfEmpty() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Can't perform the operation when the circular queue is empty.");
        }
    }

    @Override
    public int peek() {
        checkIfEmpty();
        return this.circularQueue.get(firstIndex);
    }

    @Override
    public int remove() {
        checkIfEmpty();
        final int value = this.circularQueue.get(firstIndex);
        firstIndex++;
        return value;
    }

}

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
        return this.circularQueue.isEmpty();
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

    @Override
    public int peek() {
        if (this.currentSize == 0) {
            throw new IllegalStateException("Can't peek when the circular queue is empty.");
        }
        return this.circularQueue.get(firstIndex);
    }

    @Override
    public int remove() {
        if (this.currentSize == 0) {
            throw new IllegalStateException("Can't remove when the circular queue is empty.");
        }
        final int value = this.circularQueue.get(firstIndex);
        firstIndex++;
        return value;
    }

}

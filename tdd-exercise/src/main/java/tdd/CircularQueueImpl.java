package tdd;

import java.util.List;
import java.util.ArrayList;

public class CircularQueueImpl implements CircularQueue {

    private final List<Integer> circularQueue = new ArrayList<>();
    private final int maxSize;
    private int currentSize = 0;
    private int firstIndex = 0;
    private int lastIndex = -1;

    public CircularQueueImpl(final int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    private void updateIndexes() {
        this.lastIndex++;
        if (this.lastIndex == this.maxSize) {
            this.lastIndex = 0;
            this.firstIndex++;
        }
    }

    private void addValue(final int value) {
        if (this.lastIndex < this.circularQueue.size()) {
            this.circularQueue.set(this.lastIndex, value);
        } else {
            this.circularQueue.add(value);
        }
    }

    @Override
    public void add(final int value) {
        updateIndexes();
        addValue(value);
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
        return this.circularQueue.get(this.firstIndex);
    }

    @Override
    public int remove() {
        checkIfEmpty();
        final int value = this.circularQueue.get(this.firstIndex);
        this.firstIndex++;
        this.currentSize--;
        return value;
    }

    @Override
    public int getCurrentSize() {
        return this.currentSize;
    }

}

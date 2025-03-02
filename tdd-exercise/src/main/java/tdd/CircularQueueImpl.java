package tdd;

import java.util.List;
import java.util.ArrayList;

public class CircularQueueImpl implements CircularQueue {

    private final List<Integer> circularQueue;
    private final int maxSize;
    private int currentSize = 0;
    private int firstIndex = 0;
    private int lastIndex = -1;

    public CircularQueueImpl(final int maxSize) {
        this.maxSize = maxSize;
        this.circularQueue = new ArrayList<>(this.maxSize);
    }

    private void incrementFirstIndex() {
        this.firstIndex++;
        if (this.firstIndex == this.maxSize) {
            this.firstIndex = 0;
        }
    }

    private void incrementLastIndex() {
        this.lastIndex++;
        if (this.lastIndex == this.maxSize) {
            this.lastIndex = 0;
        }
    }

    private void updateIndexes() {
        incrementLastIndex();
        if (this.currentSize == this.maxSize) {
            incrementFirstIndex();
        }
    }

    private void addValue(final int value) {
        if (this.lastIndex < this.circularQueue.size()) {
            this.circularQueue.set(this.lastIndex, value);
        } else {
            this.circularQueue.add(value);
        }
    }

    private void updateCurrentSize() {
        this.currentSize++;
        if (this.currentSize > this.maxSize) {
            this.currentSize = this.maxSize;
        }
    }

    @Override
    public void add(final int value) {
        updateIndexes();
        addValue(value);
        updateCurrentSize();
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
        final int value = this.peek();
        this.incrementFirstIndex();
        this.currentSize--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public int getCurrentSize() {
        return this.currentSize;
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }

}

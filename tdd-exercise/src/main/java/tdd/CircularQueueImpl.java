package tdd;

import java.util.List;
import java.util.ArrayList;

public class CircularQueueImpl implements CircularQueue {

    private final List<Integer> circularQueue = new ArrayList<>();
    private final int maxSize;

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
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }

}

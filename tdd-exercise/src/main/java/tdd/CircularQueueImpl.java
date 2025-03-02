package tdd;

import java.util.List;
import java.util.ArrayList;

public class CircularQueueImpl implements CircularQueue {

    private final List<Integer> circularQueue = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return this.circularQueue.isEmpty();
    }

    @Override
    public void add(final int value) {
        this.circularQueue.add(value);
    }

}

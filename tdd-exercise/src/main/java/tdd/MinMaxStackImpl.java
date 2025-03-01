package tdd;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class MinMaxStackImpl implements MinMaxStack {

    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    private void updateMinStack(final int value) {
        if (minStack.isEmpty() || value < minStack.peek()) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }
    }

    @Override
    public void push(final int value) {
        this.stack.push(value);
        updateMinStack(value);
    }

    @Override
    public int pop() {
        try {
            return this.stack.pop();
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Can't pop when the stack is empty.");
        }
    }

    @Override
    public int peek() {
        if (this.stack.peek() == null) {
            throw new IllegalStateException("Can't peek when the stack is empty.");
        }
        return this.stack.peek();
    }

    @Override
    public int getMin() {
        return this.minStack.peek();
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}

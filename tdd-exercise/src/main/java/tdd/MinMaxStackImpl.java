package tdd;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinMaxStackImpl implements MinMaxStack {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();
    private final Deque<Integer> maxStack = new ArrayDeque<>();

    private void updateMinStack(final int value) {
        if (this.minStack.isEmpty() || value < this.minStack.peek()) {
            this.minStack.push(value);
        } else {
            this.minStack.push(this.minStack.peek());
        }
    }

    private void updateMaxStack(final int value) {
        if (this.maxStack.isEmpty() || value > this.maxStack.peek()) {
            this.maxStack.push(value);
        } else {
            this.maxStack.push(this.maxStack.peek());
        }
    }

    @Override
    public void push(final int value) {
        this.stack.push(value);
        updateMinStack(value);
        updateMaxStack(value);
    }

    private void checkIfStackEmpty() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Can't perform the operation when the stack is empty.");
        }
    }

    @Override
    public int pop() {
        checkIfStackEmpty();
        this.minStack.pop();
        this.maxStack.pop();
        return this.stack.pop();
    }

    @Override
    public int peek() {
        checkIfStackEmpty();
        return this.stack.peek();
    }

    @Override
    public int getMin() {
        checkIfStackEmpty();
        return this.minStack.peek();
    }

    @Override
    public int getMax() {
        checkIfStackEmpty();
        return this.maxStack.peek();
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

package tdd;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class MinMaxStackImpl implements MinMaxStack {

    Deque<Integer> stack = new ArrayDeque<Integer>();

    @Override
    public void push(final int value) {
        this.stack.push(value);
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
        return 0;
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
        return 0;
    }
}

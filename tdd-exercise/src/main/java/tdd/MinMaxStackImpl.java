package tdd;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinMaxStackImpl implements MinMaxStack {

    Deque<Integer> stack = new ArrayDeque<Integer>();

    @Override
    public void push(final int value) {
        this.stack.push(value);
    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
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
        return true;
    }

    @Override
    public int size() {
        return 0;
    }
}

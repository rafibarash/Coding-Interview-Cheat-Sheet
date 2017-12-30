package Stack;

import java.util.Arrays;

public class ArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public ArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayStack(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[capacity];
        stack = tempStack;
        topIndex = -1;
    }

    @Override
    public void push(T newEntry) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}

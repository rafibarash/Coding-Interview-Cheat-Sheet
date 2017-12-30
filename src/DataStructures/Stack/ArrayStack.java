package DataStructures.Stack;

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

    /** Adds a new entry to the top of this stack.
     @param newEntry  an object to be added to the stack */
    public void push(T newEntry) {
        ensureCapacity();
        topIndex++;
        stack[topIndex] = newEntry;
    }

    private void ensureCapacity() {
        if (topIndex == stack.length - 1) {
            // double size of array
            stack = Arrays.copyOf(stack, 2 * stack.length);
        }
    }

    /** Removes and returns this stack’s top entry.
     @return either the object at the top of the stack or, if the
     stack is empty before the operation, null */
    public T pop() {
        T top = null;
        if (!isEmpty()) {
            top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
        }

        return top;
    }

    /** Retrieves this stack’s top entry.
     @return either the object at the top of the stack or null if
     the stack is empty */
    public T peek() {
        T top = null;
        if (!isEmpty()) {
            top = stack[topIndex];
        }

        return top;
    }

    /** Detects whether this stack is empty.
     @return true if the stack is empty */
    public boolean isEmpty() {
        return topIndex < 0;
    }

    /** Removes all entries from this stack */
    public void clear() {
        while (topIndex >= 0) {
            pop();
        }
    }
}

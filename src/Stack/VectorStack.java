package Stack;

import java.util.Vector;

public class VectorStack<T> implements StackInterface<T> {
    private Vector<T> stack;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public VectorStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public VectorStack(int capacity) {
        stack = new Vector<T>(capacity);
    }

    /** Adds a new entry to the top of this stack.
     @param newEntry  an object to be added to the stack */
    public void push(T newEntry) {
        stack.add(newEntry); // use vector method 'add'
    }

    /** Removes and returns this stack’s top entry.
     @return either the object at the top of the stack or, if the
     stack is empty before the operation, null */
    public T pop() {
        T top = null;
        if (!isEmpty()) {
            top = stack.remove(stack.size() - 1);
        }

        return top;
    }

    /** Retrieves this stack’s top entry.
     @return either the object at the top of the stack or null if
     the stack is empty */
    public T peek() {
        T top = null;
        if (!isEmpty()) {
            top = stack.lastElement();
        }

        return top;
    }

    /** Detects whether this stack is empty.
     @return true if the stack is empty */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /** Removes all entries from this stack */
    public void clear() {
        stack.clear();
    }
}

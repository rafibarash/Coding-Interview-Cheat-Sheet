package DataStructures.Queue;

public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public ArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[capacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = capacity;
    }

    public void enqueue(T newEntry) {
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
        }

        return front;

    }

    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = queue[frontIndex];
        }

        return front;
    }

    public boolean isEmpty() {
        return frontIndex == (backIndex + 1) % queue.length;
    }

    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    private void ensureCapacity() {
        if (frontIndex == (backIndex + 2) % queue.length) { // queue is full
            T[] oldQueue = queue;
            int oldSize = queue.length;
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[2 * oldSize]; // make new queue with double the size
            queue = tempQueue;
            for (int i = 0; i < oldSize - 1; i++) {
                queue[i] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }

            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }

}

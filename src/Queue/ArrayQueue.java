package Queue;

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
        T[] tempQueue = (T[])new Object[capacity+1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = capacity;
    }

    @Override
    public void enqueue(T newEntry) {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T getFront() {
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

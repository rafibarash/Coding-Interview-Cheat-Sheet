package List;

import java.util.*;

public class ArrayList<T> implements ListInterface<T> {
    private T[] list;
    private int numberOfEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempList = (T[])new Object[capacity];
        list = tempList;
    }

    @Override
    public void add(T newEntry) {

    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        return false;
    }

    @Override
    public T remove(int givenPosition) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        return false;
    }

    @Override
    public T getEntry(int givenPosition) {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public Iterator<T> getIterator() {
        return null;
    }
}

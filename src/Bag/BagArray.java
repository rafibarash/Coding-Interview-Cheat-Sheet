package Bag;

import java.util.*;

/**
 A class of bags whose entries are stored in a fixed-size array.
 */

public class BagArray<T> implements BagInterface<T> {

    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numOfEntries;

    public BagArray() {
        this(DEFAULT_CAPACITY);
    }

    public BagArray(int capacity) {
        numOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity];
        bag = tempBag;
    }

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(T newEntry) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }
}

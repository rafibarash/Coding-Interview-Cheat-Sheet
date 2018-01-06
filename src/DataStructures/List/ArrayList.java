package DataStructures.List;

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
        T[] tempList = (T[]) new Object[capacity];
        list = tempList;
    }

    public void add(T newEntry) {
        ensureCapacity();
        list[numberOfEntries] = newEntry;
        numberOfEntries++;
    }

    public boolean add(int newPosition, T newEntry) {
        boolean success = true;
        if (newPosition >= 1 && newPosition < numberOfEntries) {
            ensureCapacity();
            makeRoom(newPosition);
            list[newPosition] = newEntry;
            numberOfEntries++;
        } else {
            success = false;
        }

        return success;
    }

    public T remove(int givenPosition) {
        T removedElement = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            assert !isEmpty();
            removedElement = list[givenPosition - 1];
            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }
            numberOfEntries--;
        }

        return removedElement;
    }

    public void clear() {
        for (int i = 0; i < numberOfEntries; i++) {
            list[i] = null;
        }
    }

    public boolean replace(int givenPosition, T newEntry) {
        boolean success = true;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            assert !isEmpty();
            list[givenPosition - 1] = newEntry;
        } else {
            success = false;
        }

        return success;
    }

    public T getEntry(int givenPosition) {
        T returnEntry = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            assert !isEmpty();
            returnEntry = list[givenPosition - 1];
        }

        return returnEntry;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        int i = 0;

        while (i < numberOfEntries && !found) {
            T entry = list[i];
            if (entry == anEntry) {
                found = true;
            } else {
                i++;
            }
        }

        return found;
    }

    public int getLength() {
        assert numberOfEntries == list.length;
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = list[i];
        }

        return result;
    }

    @Override
    public Iterator<T> getIterator() {
        return null;
    }

    // Doubles size of array if full
    private void ensureCapacity() {
        if (numberOfEntries == list.length) {
            list = Arrays.copyOf(list, 2 * list.length);
        }
    }

    // makes room to add an entry into the list
    private void makeRoom(int position) {
        assert position >= 1 && position <= numberOfEntries + 1;
        int newIndex = position - 1;
        int lastIndex = numberOfEntries - 1;
        // move each entry to higher index, starting at the end and moving down list until new index
        for (int i = lastIndex; i >= newIndex; i--) {
            list[i + 1] = list[i];
        }
    }

    private void removeGap(int position) {
        assert position >= 1 && position <= numberOfEntries;
        int removedIndex = position - 1;
        int lastIndex = numberOfEntries - 1;
        for (int i = removedIndex; i < lastIndex; i++) {
            list[i] = list[i + 1];
        }
    }
}

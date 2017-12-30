package Bag;

/**
 A class of bags whose entries are stored in a fixed-size array.
 */

public class BagArray<T> implements BagInterface<T> {
    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numOfEntries;

    /** Creates empty bag with capacity 25 */
    public BagArray() {
        this(DEFAULT_CAPACITY);
    }

    /** Creates empty bag with given capacity.
        @param capacity  the integer capacity desired */
    public BagArray(int capacity) {
        numOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity];
        bag = tempBag;
    }

    /** Adds a new entry to this bag.
        @param newEntry  the object to be added as a new entry
        @return true if the addition is successful, or false if not */
    public boolean add(T newEntry) {
        boolean result = true;
        if (isFull()) {
            result = false;
        } else {
            // result is true here
            bag[numOfEntries] = newEntry;
            numOfEntries++;
        }

        return result;
    } // end add

    /** Retrieves all entries that are in this bag.
        @return a newly allocated array of all the entries in the bag */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numOfEntries];
        for (int index=0; index < numOfEntries; index++) {
            result[index] = bag[index];
        }

        return result;
    }

    /** Sees whether this bag is full.
        @return true if the bag is full, or false if not */
    public boolean isFull() {
        return numOfEntries == bag.length;
    }

    /** Sees whether this bag is empty.
        @return true if the bag is empty, or false if not */
    public boolean isEmpty() {
        return numOfEntries == 0;
    }

    /** Gets the current number of entries in this bag.
        @return the integer number of entries currently in the bag */
    public int getCurrentSize() {
        return numOfEntries;
    }

    /** Counts the number of times a given entry appears in this bag.
        @param entry the entry to be counted
        @return the number of times anEntry appears in the bag */
    public int getFrequencyOf(T entry) {
        int counter = 0;

        for (int i=0; i < numOfEntries; i++) {
            if (entry.equals(bag[i])) {
                counter ++;
            }
        }

        return counter;
    }

    /** Tests whether this bag contains a given entry.
        @param entry  the entry to locate
        @return true if the bag contains anEntry, or false otherwise */
    public boolean contains(T entry) {
        boolean found = false;

        for (int i=0; !found && (i < numOfEntries); i++) {
            if (entry.equals(bag[i])) {
                found = true;
            }
        }

        return found;
    }

    /** Removes all entries from this bag. */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
        numOfEntries = 0;
    }

    /** Removes one unspecified entry from this bag, if possible.
        @return either the removed entry, if the removal was successful, or null otherwise */
    public T remove() {
        T result = removeEntry(numOfEntries - 1);
        return result;
    }

    /** Removes one occurrence of a given entry from this bag.
        @param entry  the entry to be removed
        @return true if the removal was successful, or false if not */
    public boolean remove(T entry) {
        int index = getIndexOf(entry);
        T result = removeEntry(index);
        return entry.equals(result);
    }

    // Removes and returns the entry at a given index within the arraybag.
    // If no such entry exists, returns null.
    private T removeEntry(int index) {
        T result = null;

        if (!isEmpty() && index < numOfEntries && index >= 0) {
            result = bag[index];
            numOfEntries--;
            bag[index] = bag[numOfEntries];
            bag[numOfEntries] = null;
        }

        return result;
    }

    // Locates a given entry within the array bag.
    // Returns the index of the entry, if located, or -1 otherwise.
    private int getIndexOf(T entry) {
        boolean found = false;
        int index = -1;

        for (int i=0; !found && (i < numOfEntries); i++) {
            if (entry.equals(bag[i])) {
                found = true;
                index = i;
            }
        }

        return index;
    }
}

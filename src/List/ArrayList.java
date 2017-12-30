package List;

import java.util.Arrays;
import java.util.Iterator;

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

    /** Adds a new entry to the end of this list.
     Entries currently in the list are unaffected.
     The list’s size is increased by 1.
     @param newEntry  the object to be added as a new entry */
    public void add(T newEntry) {
        ensureCapacity();
        list[numberOfEntries] = newEntry;
        numberOfEntries++;
    }

    /** Adds a new entry at a specified position within this list.
     Entries originally at and above the specified position
     are at the next higher position within the list.
     The list’s size is increased by 1.
     @param newPosition  an integer that specifies the desired
     position of the new entry
     @param newEntry     the object to be added as a new entry
     @return true if the addition is successful, or
     false if newPosition < 1, or newPosition > getLength()+1
     */
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

    /** Removes the entry at a given position from this list.
     Entries originally at positions higher than the given
     position are at the next lower position within the list,
     and the list’s size is decreased by 1.
     @param givenPosition  an integer that indicates the position of
     the entry to be removed
     @return a reference to the removed entry or null, if either
     the list was empty, givenPosition < 1, or
     givenPosition > getLength() */
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

    /** Removes all entries from this list. */
    public void clear() {
        for (int i=0; i < numberOfEntries; i++) {
            list[i] = null;
        }
    }

    /** Replaces the entry at a given position in this list.
     @param givenPosition  an integer that indicates the position of
     the entry to be replaced
     @param newEntry  the object that will replace the entry at the
     position givenPosition
     @return true if the replacement occurs, or false if either the
     list is empty, givenPosition < 1, or
     givenPosition > getLength() */
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

    /** Retrieves the entry at a given position in this list.
     @param givenPosition  an integer that indicates the position of
     the desired entry
     @return a reference to the indicated entry or null, if either
     the list is empty, givenPosition < 1, or
     givenPosition > getLength() */
    public T getEntry(int givenPosition) {
        T returnEntry = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            assert !isEmpty();
            returnEntry = list[givenPosition - 1];
        }

        return returnEntry;
    }

    /** Sees whether this list contains a given entry.
     @param anEntry  the object that is the desired entry
     @return true if the list contains anEntry, or false if not */
    public boolean contains(T anEntry) {
        boolean found = false;
        int i = 0;

        while (i<numberOfEntries && !found) {
            T entry = list[i];
            if (entry == anEntry) {
                found = true;
            } else {
                i++;
            }
        }

        return found;
    }

    /** Gets the length of this list.
     @return the integer number of entries currently in the list */
    public int getLength() {
        assert numberOfEntries == list.length;
        return numberOfEntries;
    }

    /** Sees whether this list is empty.
     @return true if the list is empty, or false if not */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /** Retrieves all entries that are in this list in the order in which
     they occur in the list. */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        for (int i=0; i < numberOfEntries; i++) {
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
            list = Arrays.copyOf(list, 2*list.length);
        }
    }

    // makes room to add an entry into the list
    private void makeRoom(int position) {
        assert position >= 1 && position <= numberOfEntries+1;
        int newIndex = position - 1;
        int lastIndex = numberOfEntries - 1;
        // move each entry to higher index, starting at the end and moving down list until new index
        for (int i=lastIndex; i >= newIndex; i--) {
            list[i+1] = list[i];
        }
    }

    private void removeGap(int position) {
        assert position >= 1 && position <= numberOfEntries;
        int removedIndex = position - 1;
        int lastIndex = numberOfEntries - 1;
        for (int i=removedIndex; i < lastIndex; i++) {
            list[i] = list[i+1];
        }
    }
}

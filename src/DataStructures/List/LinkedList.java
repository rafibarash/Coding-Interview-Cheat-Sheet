package DataStructures.List;

import java.util.Iterator;

public class LinkedList<T> implements ListInterface<T> {
    private Node firstNode;
    private Node lastNode;
    private int numberOfEntries;

    public LinkedList() {
        clear();
    }

    /** Adds a new entry to the end of this list.
     Entries currently in the list are unaffected.
     The list’s size is increased by 1.
     @param newEntry  the object to be added as a new entry */
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.nextNode = newNode;
        }
        lastNode = newNode;
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
        boolean success = false;
        if (newPosition >= 1 && newPosition<= numberOfEntries+1) {
            success = true;
            Node newNode = new Node(newEntry);
            if (isEmpty()) {
                firstNode = newNode;
                lastNode = newNode;
            }
            else if (newPosition == 1) {
                newNode.nextNode = firstNode;
                firstNode = newNode;
            } else if (newPosition == numberOfEntries+1) {
                lastNode.nextNode = newNode;
                lastNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.nextNode;
                nodeBefore.nextNode = newNode;
                newNode.nextNode = nodeAfter;
            }
            numberOfEntries++;
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
        T result = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            assert !isEmpty();
            if (givenPosition==1) {
                result = firstNode.data;
                firstNode=firstNode.nextNode;
                if (numberOfEntries == 1) {
                    lastNode = null;
                }
            } else {
                Node nodeBefore = getNodeAt(givenPosition-1);
                Node nodeToRemove= nodeBefore.nextNode;
                Node nodeAfter = nodeToRemove.nextNode;
                nodeBefore.nextNode = nodeAfter;
                result = nodeToRemove.data;

                if (givenPosition == numberOfEntries) {
                    lastNode = nodeBefore;
                }
            }
            numberOfEntries--;
        }

        return result;
    }

    /** Removes all entries from this list. */
    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
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
            Node desiredNode = getNodeAt(givenPosition);
            desiredNode.data = newEntry;
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
        T result = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            assert !isEmpty();
            Node desiredNode = getNodeAt(givenPosition);
            result = desiredNode.data;
        }

        return result;
    }

    /** Sees whether this list contains a given entry.
     @param anEntry  the object that is the desired entry
     @return true if the list contains anEntry, or false if not */
    public boolean contains(T anEntry) {
        boolean inList = false;
        Node currentNode = firstNode;
        while (!inList && currentNode != null) {
            if (anEntry == currentNode.data) {
                inList = true;
            } else {
                currentNode = currentNode.nextNode;
            }
        }

        return inList;
    }

    /** Gets the length of this list.
     @return the integer number of entries currently in the list */
    public int getLength() {
        return numberOfEntries;
    }

    /** Sees whether this list is empty.
     @return true if the list is empty, or false if not */
    public boolean isEmpty() {
        boolean result = true;
        if (numberOfEntries==0) {
            assert firstNode==null && lastNode==null;
        } else {
            assert firstNode!=null && lastNode!= null;
            result = false;
        }

        return result;
    }

    /** Retrieves all entries that are in this list in the order in which
     they occur in the list. */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while (index < numberOfEntries && currentNode != null) {
            result[index] = currentNode.data;
            currentNode = currentNode.nextNode;
            index++;
        }
        return result;
    }

    @Override
    public Iterator<T> getIterator() {
        return null;
    }

    private Node getNodeAt(int givenPosition) {
        assert (givenPosition >= 1) && (givenPosition <= numberOfEntries) && (!isEmpty());
        Node currentNode = firstNode;
        for (int i = 1; i < givenPosition; i++) {
            currentNode = currentNode.nextNode;
        }
        assert currentNode != null;

        return currentNode;
    }

    private class Node {
        private T data;
        private Node nextNode;

        private Node(T data) {
            this.data = data;
        }

        private Node(T data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }
}

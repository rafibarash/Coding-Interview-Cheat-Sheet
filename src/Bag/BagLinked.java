package Bag;

/**
 A class of bags whose entries are stored in a chain of linked nodes.
 The bag is never full.
 */

public class BagLinked<T> implements BagInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    public BagLinked() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /** Adds a new entry to beginning of bag.
        @param newEntry  the object to be added as a new entry
        @return true */
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.nextNode = firstNode;
        firstNode = newNode;
        numberOfEntries++;

        return true;
    }

    /** Retrieves all entries that are in this bag.
        @return a newly allocated array of all the entries in the bag */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.nextNode;
        }

        return result;
    }

    /** Counts the number of times a given entry appears in this bag.
        @param anEntry the entry to be counted
        @return the number of times anEntry appears in the bag */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int counter = 0;
        Node currentNode = firstNode;
        while ((counter < numberOfEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                frequency++;
            }
            counter++;
            currentNode = currentNode.nextNode;
        }

        return frequency;
    }

    /** Sees whether this bag is empty.
     @return true if the bag is empty, or false if not */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /** Sees whether this bag is full.
     @return true if the bag is full, or false if not */
    public boolean isFull() {
        return false;
    }

    /** Gets the current number of entries in this bag.
     @return the integer number of entries currently in the bag */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /** Seaches for given entry in bag.
        @param anEntry the entry attempted to be found
        @return whether or not entry was found */
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.nextNode;
            }
        }

        return found;
    }

    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /** Removes first entry from this bag, if possible.
        @return either the removed object, if the removal was successful, or null */
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.nextNode;
            numberOfEntries--;
        }

        return result;
    }

    /** Removes one occurrence of a given entry from this bag, if possible.
        @param anEntry  the entry to be removed
        @return true if the removal was successful, or false otherwise */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node removeNode = getReferenceTo(anEntry);
        if (removeNode != null) {
            removeNode.data = firstNode.data;
            remove();
            result = true;
        }

        return result;

    }


    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located, or null otherwise.
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.nextNode;
            }
        }

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

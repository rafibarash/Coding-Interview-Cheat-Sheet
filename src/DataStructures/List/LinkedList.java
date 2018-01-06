package DataStructures.List;

import java.util.Iterator;

public class LinkedList<T> implements ListInterface<T> {
    private Node firstNode;
    private Node lastNode;
    private int numberOfEntries;

    public LinkedList() {
        clear();
    }

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

    public boolean add(int newPosition, T newEntry) {
        boolean success = false;
        if (newPosition >= 1 && newPosition <= numberOfEntries + 1) {
            success = true;
            Node newNode = new Node(newEntry);
            if (isEmpty()) {
                firstNode = newNode;
                lastNode = newNode;
            } else if (newPosition == 1) {
                newNode.nextNode = firstNode;
                firstNode = newNode;
            } else if (newPosition == numberOfEntries + 1) {
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

    public T remove(int givenPosition) {
        T result = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            assert !isEmpty();
            if (givenPosition == 1) {
                result = firstNode.data;
                firstNode = firstNode.nextNode;
                if (numberOfEntries == 1) {
                    lastNode = null;
                }
            } else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.nextNode;
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

    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

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

    public T getEntry(int givenPosition) {
        T result = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            assert !isEmpty();
            Node desiredNode = getNodeAt(givenPosition);
            result = desiredNode.data;
        }

        return result;
    }

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

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        boolean result = true;
        if (numberOfEntries == 0) {
            assert firstNode == null && lastNode == null;
        } else {
            assert firstNode != null && lastNode != null;
            result = false;
        }

        return result;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
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

package List;

import java.util.Iterator;

public class LinkedList<T> implements ListInterface<T> {
    private Node firstNode;
    private Node lastNode;
    private int numberOfEntries;

    public LinkedList() {
        clear();
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

package Queue;

public class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode;
    private Node lastNode;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    /** Adds a new entry to the back of the queue.
     @param newEntry  an object to be added */
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.nextNode = newNode;
        }
        lastNode = newNode;
    }

    /** Removes and returns the entry at the front of this queue.
     @return either the object at the front of the queue or, if the
     queue is empty before the operation, null */
    public T dequeue() {
        T front = getFront();

        assert firstNode != null;
        firstNode = firstNode.nextNode;

        if (firstNode == null) {
            lastNode = null;
        }

        return front;
    }

    /** Retrieves the entry at the front of this queue.
     @return either the object at the front of the queue or, if the
     queue is empty, null */
    public T getFront() {
        T first = null;
        if (!isEmpty()) {
            first = firstNode.data;
        }

        return first;
    }

    /** Detects whether this queue is empty.
     @return true if the queue is empty, or false otherwise */
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    /** Removes all entries from this queue. */
    public void clear() {
        firstNode = null;
        lastNode = null;
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

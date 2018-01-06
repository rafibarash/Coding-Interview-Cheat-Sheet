package DataStructures.Queue;

public class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode;
    private Node lastNode;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.nextNode = newNode;
        }
        lastNode = newNode;
    }

    public T dequeue() {
        T front = getFront();

        assert firstNode != null;
        firstNode = firstNode.nextNode;

        if (firstNode == null) {
            lastNode = null;
        }

        return front;
    }

    public T getFront() {
        T first = null;
        if (!isEmpty()) {
            first = firstNode.data;
        }

        return first;
    }

    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

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

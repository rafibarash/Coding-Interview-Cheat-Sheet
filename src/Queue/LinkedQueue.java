package Queue;

public class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode;
    private Node lastNode;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void enqueue(T newEntry) {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T getFront() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

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

package DataStructures.Stack;

/**
 * A class of stacks whose entries are stored in a chain of nodes.
 */

public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;

    public LinkedStack() {
        topNode = null;
    }

    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }

    public T pop() {
        T top = peek();
        if (topNode != null) {
            topNode = topNode.nextNode;
        }

        return top;
    }

    public T peek() {
        T top = null;
        if (topNode != null) {
            top = topNode.data;
        }

        return top;
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    public void clear() {
        topNode = null;
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

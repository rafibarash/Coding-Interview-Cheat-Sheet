package Stack;

/**
 A class of stacks whose entries are stored in a chain of nodes.
 */

public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;

    public LinkedStack() {
        topNode = null;
    }

    /** Adds a new entry to the top of this stack.
     @param newEntry  an object to be added to the stack */
    public void push(T newEntry){
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
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

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

    /** Removes and returns this stack’s top entry.
     @return either the object at the top of the stack or, if the
     stack is empty before the operation, null */
    public T pop() {
        T top = peek();
        if (topNode != null) {
            topNode = topNode.nextNode;
        }

        return top;
    }

    /** Retrieves this stack’s top entry.
     @return either the object at the top of the stack or null if
     the stack is empty */
    public T peek() {
        T top = null;
        if (topNode != null) {
            top = topNode.data;
        }

        return top;
    }

    /** Detects whether this stack is empty.
     @return true if the stack is empty */
    public boolean isEmpty() {
        return topNode == null;
    }

    /** Removes all entries from this stack */
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

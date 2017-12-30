package Tree;

public class BinaryNode<T extends Comparable<T>> implements BinaryNodeInterface<T> {
    private T data;
    private BinaryNodeInterface<T> left, right;

    public BinaryNode() {
        this(null);
    }

    public BinaryNode(T data) {
        this.data = data;
        right = null;
        left = null;
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public T getData() {
        return null;
    }

    @Override
    public void setData(T newData) {

    }

    @Override
    public BinaryNodeInterface<T> getLeftChild() {
        return null;
    }

    @Override
    public BinaryNodeInterface<T> getRightChild() {
        return null;
    }

    @Override
    public void setLeftChild(BinaryNodeInterface<T> leftChild) {

    }

    @Override
    public void setRightChild(BinaryNodeInterface<T> rightChild) {

    }

    @Override
    public boolean hasLeftChild() {
        return false;
    }

    @Override
    public boolean hasRightChild() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public int getNumberOfNodes() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public BinaryNodeInterface<T> copy() {
        return null;
    }
}

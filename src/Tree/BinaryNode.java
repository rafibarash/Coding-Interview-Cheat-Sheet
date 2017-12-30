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
        return data;
    }

    @Override
    public void setData(T newData) {
        this.data = newData;
    }

    @Override
    public BinaryNodeInterface<T> getLeftChild() {
        return left;
    }

    @Override
    public BinaryNodeInterface<T> getRightChild() {
        return right;
    }

    @Override
    public void setLeftChild(BinaryNodeInterface<T> leftChild) {
        left = leftChild;
    }

    @Override
    public void setRightChild(BinaryNodeInterface<T> rightChild) {
        right = rightChild;
    }

    @Override
    public boolean hasLeftChild() {
        return left != null;
    }

    @Override
    public boolean hasRightChild() {
        return right != null;
    }

    @Override
    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int getNumberOfNodes() {
        int leftNum = 0;
        int rightNum = 0;
        if (left != null) {
            leftNum = left.getNumberOfNodes();
        }
        if (right != null) {
            rightNum = right.getNumberOfNodes();
        }

        return 1 + leftNum + rightNum;
    }

    @Override
    public int getHeight() {
        int height = 0;
        if (this != null) {
            height = 1 + Math.max(left.getHeight(), right.getHeight());
        }
        return height;
    }


    @Override
    public BinaryNodeInterface<T> copy() {
        BinaryNodeInterface root = new BinaryNode(this.data);
        if (left != null) {
            root.setLeftChild(left.copy());
        }
        if (right != null) {
            root.setRightChild(right.copy());
        }

        return root;
    }

    @Override
    public boolean equals(Object obj) {
        BinaryNodeInterface other = (BinaryNodeInterface)obj;
        boolean left, right;

        if (other == null) {
            return false;
        }

        if (this.left == null) {
            left = other.getLeftChild() == null;
        }
        else {
            left = this.left.equals(other.getLeftChild());
        }
        if (this.right == null) {
            right = other.getRightChild() == null;
        }
        else {
            right = this.right.equals(other.getRightChild());
        }
        return left && right && this.data.equals(other.getData());
    }
}

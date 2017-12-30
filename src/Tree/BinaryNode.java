package Tree;

public class BinaryNode<T extends Comparable<T>> implements Tree.BinaryNodeInterface<T> {
    private T data;
    private Tree.BinaryNodeInterface<T> left, right;

    public BinaryNode() {
        this(null);
    }

    public BinaryNode(T data) {
        this.data = data;
        right = null;
        left = null;
    }

    public BinaryNode(T data, Tree.BinaryNode<T> left, Tree.BinaryNode<T> right) {
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
    public Tree.BinaryNodeInterface<T> getLeftChild() {
        return left;
    }

    @Override
    public Tree.BinaryNodeInterface<T> getRightChild() {
        return right;
    }

    @Override
    public void setLeftChild(Tree.BinaryNodeInterface<T> leftChild) {
        left = leftChild;
    }

    @Override
    public void setRightChild(Tree.BinaryNodeInterface<T> rightChild) {
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
    public Tree.BinaryNodeInterface<T> copy() {
        Tree.BinaryNodeInterface root = new Tree.BinaryNode(this.data);
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
        Tree.BinaryNodeInterface other = (Tree.BinaryNodeInterface)obj;
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

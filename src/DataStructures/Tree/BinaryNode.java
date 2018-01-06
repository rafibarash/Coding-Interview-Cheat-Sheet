package DataStructures.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNode<T extends Comparable<T>> implements BinaryNodeInterface<T> {
    private T data;
    private BinaryNodeInterface<T> left, right;
    private boolean visited;

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
    public void visit() {
        visited = true;
    } // end visit

    @Override
    public void unVisit() {
        visited = false;
    } // end unvisit

    @Override
    public boolean isVisited() {
        return visited;
    } // end isVisited

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
        int height = 1 + Math.max(left.getHeight(), right.getHeight());
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
        BinaryNodeInterface other = (BinaryNodeInterface) obj;
        boolean left, right;

        if (other == null) {
            return false;
        }

        if (this.left == null) {
            left = other.getLeftChild() == null;
        } else {
            left = this.left.equals(other.getLeftChild());
        }
        if (this.right == null) {
            right = other.getRightChild() == null;
        } else {
            right = this.right.equals(other.getRightChild());
        }
        return left && right && this.data.equals(other.getData());
    }

    @Override
    public void preorder() {
        preorder(this);
    }

    private void preorder(BinaryNodeInterface root) {
        System.out.println(data);
        if (left != null) {
            preorder(left);
        }
        if (right != null) {
            preorder(right);
        }
    }

    @Override
    public void inorder() {
        inorder(this);
    }

    private void inorder(BinaryNodeInterface root) {
        if (left != null) {
            inorder(left);
        }
        System.out.println(data);
        if (right != null) {
            inorder(right);
        }
    }

    @Override
    public void postorder() {
        postorder(this);
    }

    private void postorder(BinaryNodeInterface root) {
        if (left != null) {
            postorder(left);
        }
        if (right != null) {
            postorder(right);
        }
        System.out.println(data);
    }

    @Override
    public void levelorder() {
        Queue<BinaryNodeInterface> levelqueue = new LinkedList<>();
        levelqueue.add(this);
        while (!levelqueue.isEmpty()) {
            BinaryNodeInterface temp = levelqueue.poll();
            System.out.println(temp.getData());
            if (temp.hasLeftChild()) {
                levelqueue.add(temp.getLeftChild());
            }
            if (temp.hasRightChild()) {
                levelqueue.add(temp.getRightChild());
            }
        }
    }
}

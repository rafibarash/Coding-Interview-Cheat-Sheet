package Tree;

import Stack.*;
import java.util.Iterator;

public class BinaryTree<T extends Comparable<T>> implements BinaryTreeInterface<T> {

    private BinaryNodeInterface<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T rootData) {
        root = new BinaryNode<T>(rootData);
    }

    public BinaryTree(T data, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        privateSetTree(data, leftTree, rightTree);
    }

    @Override
    public void setTree(T rootData) {
        root = new BinaryNode<T>(rootData);
    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        privateSetTree(rootData, leftTree, rightTree);
    }

    private void privateSetTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        root = new BinaryNode<T>(rootData);
        if (leftTree != null && !leftTree.isEmpty()) {
            BinaryNodeInterface<T> leftNode = ((BinaryTree<T>) leftTree).getRoot();
            root.setLeftChild(leftNode);
        }
        if (rightTree != null && !rightTree.isEmpty()) {
            BinaryNodeInterface<T> rightNode = ((BinaryTree<T>) rightTree).getRoot();
            if (rightTree == leftTree) {
                root.setRightChild(rightNode.copy());
            } else {
                root.setRightChild(rightNode);
            }

        }
        if (leftTree != null && leftTree != this) {
            leftTree.clear();
        }
        if (rightTree != null && rightTree != this) {
            rightTree.clear();
        }
    }

    @Override
    public T getRootData() {
        T rootData = null;
        if (root != null) {
            rootData = root.getData();
        }

        return rootData;
    }

    public BinaryNodeInterface<T> getRoot() {
        return root;
    }

    @Override
    public int getHeight() {
        return root.getHeight();
    }

    @Override
    public int getNumberOfNodes() {
        return root.getNumberOfNodes();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return new PreOrderIterator<>();
    }

    private class PreOrderIterator<T> implements Iterator {
        private StackInterface<BinaryNodeInterface> stack = new LinkedStack<>();

        public PreOrderIterator() {
            stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            assert !stack.isEmpty();
            BinaryNodeInterface node = stack.pop();
            if (node.getRightChild() != null) {
                stack.push(node.getRightChild());
            }
            if (node.getLeftChild() != null) {
                stack.push(node.getLeftChild());
            }

            return (T)node.getData();
        }
    }

    // TODO
    @Override
    public Iterator<T> getPostorderIterator() {
        return new PostOrderIterator<>();
    }

    private class PostOrderIterator<T> implements Iterator {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }

    // TODO
    @Override
    public Iterator<T> getInorderIterator() {
        return new InOrderIterator<>();
    }

    private class InOrderIterator<T> implements Iterator {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }

    // TODO
    @Override
    public Iterator<T> getLevelOrderIterator() {
        return new LevelOrderIterator<>();
    }

    private class LevelOrderIterator<T> implements Iterator {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}

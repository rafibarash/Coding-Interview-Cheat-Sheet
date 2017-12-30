package Tree;

import Stack.LinkedStack;
import Stack.StackInterface;

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

    }

    @Override
    public void setTree(T rootData) {

    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {

    }

    @Override
    public T getRootData() {
        return null;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getNumberOfNodes() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getInorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getLevelOrderIterator() {
        return null;
    }
}

package Tree;

public interface BinaryTreeInterface<T extends Comparable<T>> extends Tree.TreeInterface<T>, Tree.TreeIteratorInterface<T> {

    /** Sets this binary tree to a new one-node binary tree.
    @param rootData an object that is the data in the new tree’s root */
    public void setTree(T rootData);

    /** Sets this binary tree to a new binary tree.
     @param rootData an object that is the data in the new tree’s root @param leftTree the left subtree of the new tree
     @param rightTree the right subtree of the new tree */
    public void setTree(T rootData, Tree.BinaryTreeInterface<T> leftTree, Tree.BinaryTreeInterface<T> rightTree);
}

package Tree;

import java.util.Iterator;

public class Tree<T extends Comparable<T>> implements TreeInterface<T> {

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

    private class TreeIterator<T> implements TreeIteratorInterface<T> {

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
}

package DataStructures.Dictionary;

/**
 * Time Complexity Analysis of Operations
 * Addition: O(n)
 * Removal: O(n)
 * Retrieval: O(n)
 * Traversal: O(n)
 */

import java.util.*;

public class UnsortedArrayDictionary<K, V> implements DictionaryInterface<K, V> {
    private Entry<K, V>[] dictionary;
    private int numberOfEntries;
    private final static int DEFAULT_INITIAL_CAPACITY = 25;

    public UnsortedArrayDictionary() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public UnsortedArrayDictionary(int capacity) {
        dictionary = (Entry<K, V>[]) new Entry[capacity];
        numberOfEntries = 0;
    }

    public V add(K key, V value) {
        V result = null;
        int keyIndex = locateIndex(key);
        if (keyIndex < numberOfEntries) {
            result = dictionary[keyIndex].getValue();
            dictionary[keyIndex].setValue(value);
        } else {
            ensureCapacity();
            dictionary[numberOfEntries] = new Entry<K, V>(key, value);
            numberOfEntries++;
        }

        return result;
    }

    public V remove(K key) {
        V result = null;
        int keyIndex = locateIndex(key);
        if (keyIndex < numberOfEntries) {
            result = dictionary[keyIndex].getValue();
            dictionary[keyIndex] = dictionary[numberOfEntries - 1];
            numberOfEntries--;
        }

        return result;
    }

    public V getValue(K key) {
        V result = null;
        int keyIndex = locateIndex(key);
        if (keyIndex < numberOfEntries) {
            result = dictionary[keyIndex].getValue();
        }

        return result;
    }

    public boolean contains(K key) {
        return locateIndex(key) < numberOfEntries;
    }

    public Iterator<K> getKeyIterator() {
        return new KeyIterator<>();
    }

    public Iterator<V> getValueIterator() {
        return new ValueIterator<>();
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public int getSize() {
        return numberOfEntries;
    }

    public void clear() {
        dictionary = (Entry<K, V>[]) new Entry[25];
        numberOfEntries = 0;
    }

    // Doubles the size of the array of entries if it is full.
    protected void ensureCapacity() {
        if (numberOfEntries == dictionary.length) {
            dictionary = Arrays.copyOf(dictionary, 2 * dictionary.length);
        }
    }

    // Returns the index of the entry that contains key or
    // returns numberOfEntries if no such entry exists.
    protected int locateIndex(K key) {
        int index = 0;
        while ((index < numberOfEntries) && (!key.equals(dictionary[index].getKey()))) {
            index++;
        }

        return index;
    }

    protected class Entry<K, T> {
        private K key;
        private T value;

        protected Entry(K key, T value) {
            this.key = key;
            this.value = value;
        }

        protected K getKey() {
            return key;
        }

        protected T getValue() {
            return value;
        }

        protected void setValue(T value) {
            this.value = value;
        }
    }

    private class KeyIterator<K> implements Iterator<K> {
        private int nextIndex;
        private boolean isRemoveOrSetLegal;

        private KeyIterator() {
            nextIndex = 0;
            isRemoveOrSetLegal = false;
        }

        public boolean hasNext() {
            return nextIndex < numberOfEntries;
        }

        public K next() {
            if (hasNext()) {
                return (K) dictionary[nextIndex].getKey();
            } else {
                throw new NoSuchElementException("Iterator is at end of list.");
            }
        }
    }

    private class ValueIterator<V> implements Iterator<V> {
        private int nextIndex;

        private ValueIterator() {
            nextIndex = 0;
        }

        public boolean hasNext() {
            return nextIndex < numberOfEntries;
        }

        public V next() {
            if (hasNext()) {
                return (V) dictionary[nextIndex].getValue();
            } else {
                throw new NoSuchElementException("Iterator is at end of list.");
            }
        }
    }
}

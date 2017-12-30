package Dictionary;

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

    @Override
    public V add(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V getValue(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public Iterator<K> getKeyIterator() {
        return null;
    }

    @Override
    public Iterator<V> getValueIterator() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clear() {

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
}

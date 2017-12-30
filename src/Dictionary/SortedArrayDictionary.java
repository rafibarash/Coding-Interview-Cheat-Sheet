package Dictionary;

import java.util.*;

public class SortedArrayDictionary<K extends Comparable<? super K>, V> extends UnsortedArrayDictionary<K, V>
        implements DictionaryInterface<K, V> {

    private Entry<K, V>[] dictionary;
    private int numberOfEntries;
    private final static int DEFAULT_INITIAL_CAPACITY = 25;

    public SortedArrayDictionary() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public SortedArrayDictionary(int capacity) {
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

    // Returns the index of the entry that contains key or
    // returns numberOfEntries if no such entry exists.
    // Binary search until find where index should be
    private int locateIndex(K key) {
        return 0;
    }

    // Makes room for entry at index by shifting entries to end of array
    private void makeRoom(int keyIndex) {
    }
}

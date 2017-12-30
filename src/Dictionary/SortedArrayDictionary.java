package Dictionary;

/**
 * Time Complexity Analysis of Operations
 * Addition: O(n)
 * Removal: O(n)
 * Retrieval: O(log(n))
 * Traversal: O(n)
 */

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
        V result = null;
        int keyIndex = locateIndex(key);
        if (keyIndex < numberOfEntries && key.equals(dictionary[keyIndex].getKey())) {
            result = dictionary[keyIndex].getValue();
            dictionary[keyIndex].setValue(value);
        } else {
            ensureCapacity();
            makeRoom(keyIndex);
            dictionary[keyIndex] = new Entry<K, V>(key, value);
            numberOfEntries++;
        }

        return result;
    }

    @Override
    public V remove(K key) {
        V result = null;
        int keyIndex = locateIndex(key);
        if (keyIndex < numberOfEntries && key.equals(dictionary[keyIndex].getKey())) {
            result = dictionary[keyIndex].getValue();
            for (int i = keyIndex; i < numberOfEntries; i++) {
                dictionary[i] = dictionary[i + 1];
            }
            numberOfEntries--;
        }

        return result;
    }

    @Override
    // binary search until find where index should be
    protected int locateIndex(K key) {
        int index = numberOfEntries;
        int end = numberOfEntries - 1;
        int start = 0;
        boolean found = false;

        while (start <= end && !found) {
            int mid = (start + end) / 2;
            if (key.compareTo(dictionary[mid].getKey()) == 0) {
                index = mid;
                found = true;
            } else if (key.compareTo(dictionary[mid].getKey()) > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }

    // Makes room for entry at index by shifting entries to end of array
    private void makeRoom(int keyIndex) {
        for (int end = numberOfEntries; end > keyIndex; end--) {
            dictionary[end] = dictionary[end - 1];
        }
        dictionary[keyIndex] = null;
    }
}

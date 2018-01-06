package Searching;

// ONLY WORKS IF ARRAY IS SORTED
public class BinarySearch<T> {

    public static <T extends Comparable<T>> boolean iterativeSearch(T[] array, T searchEl) {
        int high = array.length - 1;
        int low = 0;
        boolean found = false;
        while (high >= low && !found) {
            int mid = (high + low) / 2;
            T el = array[mid];
            if (el.equals(searchEl)) {
                found = true;
            } else if (el.compareTo(searchEl) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return found;
    }

    public static <T extends Comparable<T>> boolean recursiveSearch(T[] array, T searchEl) {
        int high = array.length - 1;
        int low = 0;
        return recursiveSearch(array, searchEl, low, high);
    }

    private static <T extends Comparable<T>> boolean recursiveSearch(T[] array, T searchEl, int low, int high) {
        boolean found = false;
        if (low <= high) {
            int mid = (low + high) / 2;
            T el = array[mid];
            if (el.equals(searchEl)) {
                found = true;
            } else if (el.compareTo(searchEl) > 0) {
                recursiveSearch(array, searchEl, low, mid - 1);
            } else {
                recursiveSearch(array, searchEl, mid + 1, high);
            }
        }

        return found;
    }
}

package Searching;

public class LinearSearch<T> {

    public static <T extends Comparable<T>> boolean search(T[] array, T searchEl) {
        boolean found = false;
        for (int i = 0; i < array.length && !found; i++) {
            if (array[i].equals(searchEl)) {
                found = true;
            }
        }

        return found;
    }

}

package Sorting;

public class QuickSort<T> {

    public static <T extends Comparable<T>> void quicksort(T[] array, int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) {
            quicksort(array, left, index - 1);
        }
        if (index < right) {
            quicksort(array, index, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        T pivot = array[(right + left) / 2];

        while (left <= right) {
            if (array[left].compareTo(pivot) < 0) {
                left++;
            }
            if (array[right].compareTo(pivot) > 0) {
                right--;
            }
            if (array[left].compareTo(array[right]) >= 0) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static <T extends Comparable<T>> void swap(T[] array, int left, int right) {
        T temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

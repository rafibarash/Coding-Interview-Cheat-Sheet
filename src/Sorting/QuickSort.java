package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static int[] quicksort(int[] array, int low, int high) {
        int index = partition(array, low, high);
        // sort left half
        if (low < index - 1) {
            quicksort(array, low, index - 1);
        }
        // sort right half
        if (index < high) {
            quicksort(array, index, high);
        }
        return array;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[(low + high) / 2];
        while (low <= high) {
            // find element on left that should be on right
            while (array[low] < pivot) {
                low++;
            }
            // find element on right that should be on left
            while (array[high] > pivot) {
                high--;
            }
            // swap element, increment/decrement low and high
            if (low <= high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] test1a = {1, 5, 6, 3, 2, 77, 4, 9};
        System.out.println(Arrays.toString(test1a));
        int[] test1b = QuickSort.quicksort(test1a, 0, test1a.length - 1);
        System.out.println(Arrays.toString(test1b));
    }
}

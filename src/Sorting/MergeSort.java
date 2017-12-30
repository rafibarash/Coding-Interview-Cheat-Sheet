package Sorting;

import java.util.Arrays;

public class MergeSort<T> {

    public static <T extends Comparable<T>> void mergesort(T[] array) {
        T[] helper = (T[]) new Object[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void mergesort(T[] array, T[] helper, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergesort(array, helper, low, mid);
            mergesort(array, helper, mid + 1, high);
            merge(array, helper, low, mid, high);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] helper, int low, int mid, int high) {
        int beginIndex1 = low;
        int endIndex1 = mid;
        int beginIndex2 = mid + 1;
        int endIndex2 = high;
        int current = 0;

        while (beginIndex1 <= endIndex1 && beginIndex2 <= endIndex2) {
            if (array[beginIndex1].compareTo(array[beginIndex2]) >= 0) {
                helper[current] = array[beginIndex1];
                beginIndex1++;
            } else {
                helper[current] = array[beginIndex2];
                beginIndex2++;
            }
            current++;
        }

        if (beginIndex1 <= endIndex1) {
            beginIndex1 += beginIndex2;
            while (beginIndex1 <= array.length - 1) {
                helper[current] = array[beginIndex1];
                current++;
                beginIndex1++;
            }
        } else if (beginIndex2 <= endIndex2) {
            beginIndex2 += beginIndex1;
            while (beginIndex2 <= array.length - 1) {
                helper[current] = array[beginIndex2];
                current++;
                beginIndex2++;

                array = Arrays.copyOf(helper, helper.length);

            }
        }
    }
}
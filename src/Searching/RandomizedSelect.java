package Searching;

public class RandomizedSelect {
    public static int randomizedSelect(int[] lst, int low, int high, int index) {
        if (low == high) {
            return lst[low];
        }
        int partition = partition(lst, low, high);
        int pivot = partition - low + 1;
        if (index == pivot) {
            return lst[partition];
        } else if (index < pivot) {
            return randomizedSelect(lst, low, partition - 1, index);
        } else {
            return randomizedSelect(lst, partition + 1, high, index - pivot);
        }
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
}

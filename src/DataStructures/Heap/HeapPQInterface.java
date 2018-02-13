package DataStructures.Heap;

import java.util.*;

public interface HeapPQInterface<T> extends DataStructures.Queue.QueueInterface {

    /* Repair heap containing sub-heap with broken root */
    public void maxHeapify(ArrayList<T> list, int index);

    /* Builds max heap from previously 'unheaped' array */
    public void buildMaxHeap();

    /* Sorts heap in place */
    public void heapSort();

}

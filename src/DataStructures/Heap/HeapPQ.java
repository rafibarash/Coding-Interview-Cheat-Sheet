package DataStructures.Heap;

import java.util.*;

public class HeapPQ<T extends Comparable<T>> implements HeapPQInterface<T> {
    private ArrayList<T> heap;
    private final static int DEFAULT_INITIAL_CAPACITY = 25;
    private int numOfElements;

    public HeapPQ(ArrayList<T> heap, int numOfElements) {
        this.heap = heap;
        this.numOfElements = numOfElements;
    }

    public HeapPQ(ArrayList<T> heap) {
        this(heap, DEFAULT_INITIAL_CAPACITY);
    }

    public HeapPQ() {
        this(new ArrayList<>(), DEFAULT_INITIAL_CAPACITY);
    }

    @Override
    public void maxHeapify(ArrayList<T> list, int index) {
        int largest = index;
        int left = left(index);
        int right = right(index);
        if (left < numOfElements && heap.get(left).compareTo(heap.get(index)) > 0) {
            largest = left;
        }
        if (right < numOfElements && heap.get(right).compareTo(heap.get(largest)) > 0) {
            largest = right;
        }
        if (largest != index) {

        }
    }

    @Override
    public void buildMaxHeap() {

    }

    @Override
    public void heapSort() {

    }

    @Override
    public void enqueue(Object newEntry) {

    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public Object getFront() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    private int left(int parentIndex) {
        return 2 * parentIndex;
    }

    private int right(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private double parent(double childIndex) {
        return Math.floor(childIndex / 2.0);
    }
}

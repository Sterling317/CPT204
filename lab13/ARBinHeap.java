package lab13;

import java.util.Arrays;

/**
 * Resizing-array-based Binary Heap
 */
public class ARBinHeap<T extends Comparable<T>> implements MinPQ<T> {

    private T[] heap;     // store items at indices 1 to n
    private int size;     // number of items on binary heap

    /*
     ********************
     Helper methods start
     ********************
     */



    /*
     ******************
     Helper methods end
     ******************
     */


    // LAB EXERCISE 13.1 CONSTRUCTORS

    /**
     * Initializes an empty binary heap with the given initial capacity.
     *
     * @param initCapacity the initial capacity of this binary heap
     */
    @SuppressWarnings("unchecked")
    public ARBinHeap(int initCapacity) {
        heap = (T[]) new Comparable[initCapacity];
        size = 0;

    }


    /**
     * Initializes an empty binary heap.
     */
    public ARBinHeap() {
        this(1);
    }


    // LAB EXERCISE 13.2 GETMIN

    /**
     * Returns a smallest item on this binary heap.
     * This binary heap is not empty.
     *
     * @return a smallest item on this binary heap
     */
    @Override
    public T getMin() {
        if (size > 0) {
            return heap[1];
        }

        return null;
    }


    // LAB EXERCISE 13.3 ADD

    /**
     * Adds a new item to this binary heap.
     *
     * @param item the item to add to this binary heap
     */
    @Override
    public void add(T item) {

        if (size + 1 >= heap.length) {
            resize(heap.length * 2);
        }
//        System.out.println("size = " + size + " ---- heap.leangth = " + heap.length);
        heap[++size] = item;

        swim(size);
    }

    private boolean greater(int i, int j) {
        return ((Comparable<T>) heap[i]).compareTo(heap[j]) > 0;
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    @SuppressWarnings("unchecked")
    public void resize(int newSize) {
        T[] newHeap = (T[]) new Comparable[newSize];
        for (int i = 1; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }

        heap = newHeap;

    }

    // LAB EXERCISE 13.4 DELMIN

    /**
     * Removes and returns a smallest item on this binary heap.
     * This binary heap is not empty.
     *
     * @return a smallest item on this binary heap
     */
    @Override
    public T delMin() {
        if (size > 0) {
            T min = getMin();
            swap(1, size);
            size--;
            sink(1);
            heap[size + 1] = null;
            return min;
        }

        return null;
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    // DO NOT MODIFY CODE BELOW
    // for testing and visualization

    /**
     * Returns true if this binary heap is empty.
     *
     * @return true if this binary heap is empty;
     * false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the number of items on this binary heap.
     *
     * @return the number of items on this binary heap
     */
    @Override
    public int size() {
        return size;
    }

    public T[] toArray() {
        return heap;
    }

    public int[] toPriority(){
        return null;
    }

    public static void main(String[] args) {
//        ARBinHeap<Integer> pq = new ARBinHeap<>();
//        System.out.println(pq.isEmpty());
//        System.out.println(pq.size());
//        pq.add(6);
//        pq.add(3);
//        pq.add(9);
//        System.out.println(pq.getMin());
//        pq.add(7);
//        pq.add(5);
//        pq.add(8);
//        pq.add(2);
//
//        Object[] arr = pq.toArray();
//        for (int i = 1; i <= pq.size(); i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//
//        System.out.println(pq.delMin());
//
//        arr = pq.toArray();
//        for (int i = 1; i <= pq.size(); i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();


        MinPQ<Integer> minPQ = new ARBinHeap<>();
        minPQ.add(11);
        minPQ.add(16);
        minPQ.add(15);
        minPQ.add(35);
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
//        System.out.println(minPQ.size());
//        System.out.println(minPQ.getMin());
//        System.out.println(minPQ.delMin());
//        System.out.println(minPQ.getMin());
//        System.out.println(minPQ.size());
//        System.out.println(minPQ.delMin());
//        System.out.println(minPQ.size());
//        System.out.println(minPQ.getMin());
//        System.out.println(minPQ.delMin());
//        System.out.println(minPQ.size());
    }
}
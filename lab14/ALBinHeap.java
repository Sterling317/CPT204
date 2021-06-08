package lab14;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *  ArrayList-based Binary Heap
 */
public class ALBinHeap<T> implements ExpMinPQ<T> {

    private final ArrayList<Node> heap;     // store items at indices 1 to n
    private int size;                       // number of items on binary heap

    /**
     * Represents a value-explicit priority pair.
     */
    private class Node {
        T item;
        int priority;

        Node(T item, int priority) {
            this.item = item;
            this.priority = priority;
        }
    }

    /*
     ********************
     Helper methods start
     ********************
     */

    // INCLUDE ALL YOUR HELPER METHODS
    // IN YOUR LEARNING MALL SUBMISSION !

    //a helper method to decide whether an item at index i is greater than the item at index j
    private boolean greater(int i, int j) {
        return heap.get(i).priority > heap.get(j).priority;
    }

    private void swap(int i, int j) {
        Node temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }

    // swap child with the parent, until heap property is restored
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            swap(k, k/2);
            k = k/2; }
    }

    // swap parent with the smaller child, until heap property is restored
    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && greater(j, j+1)) j++; if (!greater(k, j)) break;
            swap(k, j);
            k = j;
        }
    }


    /*
     ******************
     Helper methods end
     ******************
     */


    // LAB 14 PART A.1 EMPTY CONSTRUCTOR

    /**
     * Initializes an empty binary heap.
     */
    public ALBinHeap() {
        heap = new ArrayList<>();
        heap.add(new Node(null,0));
        size = 0;
    }
	
	
	// LAB 14 PART A.2 GETMIN

    /**
     * Returns an item with a smallest priority on this binary heap.
     * @return an item with a smallest priority on this binary heap
     * @throws NoSuchElementException if this binary heap is empty
     */
    @Override
    public T getMin() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size > 0) {
            return heap.get(1).item;
        }
        return null;
    }


    // LAB 14 PART A.3 ADD

    /**
     * Adds a new item with its priority to this binary heap.
     * @param  item the item to add to this binary heap
     * @param priority the priority of the item
     * @throws IllegalArgumentException if item is null
     */
    @Override
    public void add(T item, int priority) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        heap.add(new Node(item,priority));
        size++;
        swim(size);
    }

    // LAB 14 PART A.4 DELMIN

    /**
     * Removes and returns an item with a smallest priority on this binary heap.
     * @return an item with a smallest priority on this binary heap
     * @throws NoSuchElementException if this binary heap is empty
     */
    @Override
    public T delMin() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size > 0) {
            T min = heap.get(1).item;
            swap(1, size);
            size--;
            sink(1);
            heap.remove(size + 1);
            return min;
        }
        return null;
    }
	

    // DO NOT MODIFY CODE BELOW
    // for testing and visualization
	
	/**
     * Returns true if this binary heap is empty.
     * @return true if this binary heap is empty;
     *         false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items on this binary heap.
     * @return the number of items on this binary heap
     */
    @Override
    public int size() {
        return size;
    }
		
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) new Object[size() + 1];
        result[0] = null;
        for (int i = 1; i <= size(); i++) {
            result[i] = heap.get(i).item;;
        }
        return result;
    }

}

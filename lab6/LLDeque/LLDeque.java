package lab6.LLDeque;

public class LLDeque<T> {

    private class Node {
        Node prev;
        T item;
        Node next;

        Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * @return the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * @return true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */


    // EXERCISE 6.1 COPY CONSTRUCTOR

    /**
     * Creates a (deep) copy of another Deque object.
	 * @param other is another LLDeque<T> object.
     */
    public LLDeque(LLDeque<T> other) {
		
		
		
    }


    // EXERCISE 6.2 ADD NOT NULL TO FRONT

    /**
     * Adds an non-null item of type T to the front of the deque.
     * @param item is a type T object.
     * @throws IllegalArgumentException if the item is null.
     */
    public void addFirst(T item) {
		
		
		
    }


    // EXERCISE 6.3 ADD LEGAL ITEM TO FRONT

    /**
     * Adds the first item of type T to the front of the deque,
     * or the second item of type T instead if the first item is illegal.
     * @param item1 is a type T object.
     * @param item2 is a type T object.
     */
    public void addLegalFirst(T item1, T item2) {
		
		
		
    }
	
	
	
	
    /*
     *************************************************************
     * You can copy paste Lab 5 codes below if you want to use it
     *************************************************************
     */

    
	
	
	

}

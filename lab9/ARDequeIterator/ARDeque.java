package lab9.ARDequeIterator;

public class ARDeque<T> {
	
	// Copy Paste your ARDeque implementation from Lab 8 here !
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;


    /**
     * @return the size of the array used in the deque.
     */
    public int itemsLength() {
        return items.length;
    }

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


    /*
     ******************* HELPER METHODS START *******************
     ***** Include your helper method(s) in EACH Submission *****
     *********************** that uses it ***********************
     */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /* Resizes the underlying array to the target capacity. */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        int curr = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            newArray[i] = items[curr];
            curr = plusOne(curr);
        }
        items = newArray;
        nextFirst = capacity -1;
        nextLast = size;
    }

    /*
     ******************** HELPER METHODS END ********************
     */


    // LAB EXERCISE 8.1 EMPTY CONSTRUCTOR

    /**
     * Creates an empty deque.
     */
    @SuppressWarnings("unchecked")
    public ARDeque() {
        items = (T[]) new Object[4];
        size = 0;
        nextFirst = 2;
        nextLast = 3;


    }


    // LAB EXERCISE 8.2 ADD TO BACK

    /**
     * Adds an item of type T to the back of the deque.
     * @param item is a type T object to be added.
     */
    public void addLast(T item) {
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;

    }


    // LAB EXERCISE 8.3 PRINT ITEMS

    /**
     * Prints the items in the deque from first to last,
     * separated by a space, ended with a new line.
     */
    public void printDeque() {
        int first = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.println(items[first] + " ");
            first = plusOne(first);
        }
        System.out.println();
    }


    // LAB EXERCISE 8.4 GET ITEM

    /**
     * Gets the item at the given index.
     * Does not mutate the deque.
     * @param index is an index where 0 is the front.
     * @return the index-th item of the deque.
     * @throws IndexOutOfBoundsException if no item exists at the given index.
     */
    public T get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index" + index + "is not valid");
        }
        int realIndex = (plusOne(nextFirst) + index) % items.length;
        return items[realIndex];
    }


    // EXERCISE 8.1 ADD TO FRONT

    /**
     * Adds an item of type T to the front of the deque.
     * @param item is a type T object to be added.
     */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }


    // EXERCISE 8.2 DELETE FRONT

    /**
     * Deletes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return the first item of the deque, null if it does not exist.
     */
    public T delFirst() {
        if (size == 0) {
            return null;
        } else {
            T item = items[plusOne(nextFirst)];
            items[plusOne(nextFirst)] = null;
            nextFirst = plusOne(nextFirst);
            size--;
            if (size <= items.length/4) {
                resize(items.length/2);
            }
            return item;
        }
    }


    // EXERCISE 8.3 DELETE BACK

    /**
     * Deletes and returns the item at the back  of the deque.
     * If no such item exists, returns null.
     * @return the last item of the deque, null if it does not exist.
     */
    public T delLast() {
        if (size == 0) {
            return null;
        } else {
            T item = items[minusOne(nextLast)];
            items[minusOne(nextLast)] = null;
            nextLast = minusOne(nextLast);
            size--;
            if (size <= items.length/4) {
                resize(items.length/2);
            }
            return item;
        }
    }




}